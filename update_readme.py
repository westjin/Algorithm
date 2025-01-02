import os
import json
import subprocess
from datetime import datetime

# 저장소 경로와 README 파일 경로 설정
repo_path = "./"  # 저장소 루트 경로
readme_path = os.path.join(repo_path, "README.md")
cache_path = os.path.join(repo_path, "problem_data_cache.json")

# README 헤더 템플릿
readme_template = """
# 알고리즘 저장소 📚

이 저장소는 백준 온라인 저지와 프로그래머스에서 해결한 알고리즘 문제 풀이를 모아둔 공간입니다. 🚀

---

## 📝 해결한 문제들
"""

# JSON 캐싱 데이터 로드
def load_cache():
    if os.path.exists(cache_path):
        with open(cache_path, "r") as cache_file:
            return json.load(cache_file)
    return {}

# JSON 캐싱 데이터 저장
def save_cache(cache):
    with open(cache_path, "w") as cache_file:
        json.dump(cache, cache_file, indent=4, ensure_ascii=False)

# Git 커밋 날짜 가져오기
def get_git_commit_date(file_path):
    try:
        result = subprocess.run(
            ["git", "log", "-1", "--format=%ci", file_path],
            cwd=repo_path,
            stdout=subprocess.PIPE,
            text=True,
            check=True
        )
        commit_date = result.stdout.strip().split(" ")[0]
        return commit_date
    except Exception as e:
        print(f"Git 커밋 날짜를 가져오는 중 오류 발생: {e}")
        return "Unknown"

# 난이도 및 분류 데이터 가져오기
def get_problem_data(problem_number, platform, root):
    if platform == "백준":
        # 백준 난이도
        difficulties = ["Bronze", "Silver", "Gold", "Platinum"]
        for difficulty in difficulties:
            if difficulty in root:
                return {"difficulty": difficulty, "tags": "미분류"}
    elif platform == "프로그래머스":
        # 프로그래머스 난이도
        if "1/" in root:
            return {"difficulty": "Level 1", "tags": "미분류"}
        elif "2/" in root:
            return {"difficulty": "Level 2", "tags": "미분류"}
    return {"difficulty": "Unknown", "tags": "미분류"}

# 문제 목록 생성
def classify_and_filter_problems(base_path, platform, cache):
    for root, dirs, files in os.walk(base_path):
        for folder in dirs:
            problem_number = folder.split(".")[0]
            folder_path = os.path.join(root, folder)
            if problem_number not in cache:
                problem_data = get_problem_data(problem_number, platform, root)
                cache[problem_number] = {
                    "name": folder,
                    "link": f"https://www.acmicpc.net/problem/{problem_number}" if platform == "백준" else f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_number}",
                    "date": get_git_commit_date(folder_path),
                    "difficulty": problem_data["difficulty"],
                    "tags": problem_data["tags"],
                    "solved": "✅",
                }
    return cache

# 난이도별 문제 텍스트 생성
def generate_markdown_by_difficulty(problem_dict, platform):
    problem_text = f"### 📌 {platform}\n\n"

    difficulty_levels = ["Bronze", "Silver", "Gold", "Platinum", "Level 1", "Level 2", "Level 3", "Unknown"]
    for level in difficulty_levels:
        problems = [p for p in problem_dict.values() if p["difficulty"] == level]
        if problems:
            problem_text += f"#### {level}\n"
            problem_text += "| **문제** | **분류** | **풀이 날짜** | **해결 여부** |\n"
            problem_text += "|----------|----------|---------------|---------------|\n"
            for problem in problems:
                problem_text += f"| [{problem['name']}]({problem['link']}) | {problem['tags']} | {problem['date']} | {problem['solved']} |\n"
            problem_text += "\n"

    return problem_text

# README 업데이트
def update_readme():
    cache = load_cache()

    # 백준 문제 목록 생성
    baekjoon_path = os.path.join(repo_path, "백준")
    cache = classify_and_filter_problems(baekjoon_path, "백준", cache)
    
    # 프로그래머스 문제 목록 생성
    programmers_path = os.path.join(repo_path, "프로그래머스")
    cache = classify_and_filter_problems(programmers_path, "프로그래머스", cache)

    # README 생성
    baekjoon_text = generate_markdown_by_difficulty(cache, "백준")
    programmers_text = generate_markdown_by_difficulty(cache, "프로그래머스")
    with open(readme_path, "w") as readme_file:
        readme_file.write(readme_template)
        readme_file.write(baekjoon_text)
        readme_file.write(programmers_text)

    save_cache(cache)

if __name__ == "__main__":
    update_readme()
