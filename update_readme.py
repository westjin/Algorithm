import os
import subprocess
from datetime import datetime

# 저장소 경로와 README 파일 경로 설정
repo_path = "./"  # 저장소 루트 경로
readme_path = os.path.join(repo_path, "README.md")

# README 헤더 템플릿
readme_template = """
# 알고리즘 저장소 📚

이 저장소는 백준 온라인 저지와 프로그래머스에서 해결한 알고리즘 문제 풀이를 모아둔 공간입니다. 🚀

---

## 📝 해결한 문제들
"""

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
        commit_date = result.stdout.strip().split(" ")[0]  # 날짜 부분만 추출
        return commit_date
    except Exception as e:
        print(f"Git 커밋 날짜를 가져오는 중 오류 발생: {e}")
        return "Unknown"

# 수동으로 태그 관리
def get_manual_tags(problem_name, platform):
    manual_tags = {
        # 백준 문제 태그 (수동 입력)
        "백준": {
            "11286": "우선순위 큐, 정렬",
            "12891": "문자열, 슬라이딩 윈도우",
            # 추가 태그를 여기 추가
        },
        # 프로그래머스 문제 태그 (수동 입력)
        "프로그래머스": {
            "12906": "스택, 큐",
            "42586": "스택, 큐, 구현",
            # 추가 태그를 여기 추가
        },
    }
    return manual_tags.get(platform, {}).get(problem_name, "미분류")

# 백준 난이도 추출
def get_baekjoon_difficulty(root):
    difficulties = ["Bronze", "Silver", "Gold", "Platinum"]
    for difficulty in difficulties:
        if difficulty in root:
            return difficulty
    return "Unknown"

# 문제 목록 생성
def classify_and_filter_problems(base_path, platform):
    problem_dict = {}

    for root, dirs, files in os.walk(base_path):
        for file in files:
            if file.endswith(".md") or file.endswith(".py") or file.endswith(".java"):  # 문제 파일 필터링
                if file == "README.md":  # README 제외
                    continue

                problem_name = os.path.splitext(file)[0]
                file_path = os.path.join(root, file)

                if platform == "백준":
                    difficulty = get_baekjoon_difficulty(root)
                    tags = get_manual_tags(problem_name, platform)  # 수동 태그 관리
                elif platform == "프로그래머스":
                    difficulty = root.split("/")[0]  # Level 구분
                    tags = get_manual_tags(problem_name, platform)  # 수동 태그 관리
                else:
                    difficulty = "Unknown"
                    tags = "미분류"

                if problem_name not in problem_dict:
                    problem_dict[problem_name] = {
                        "name": problem_name,
                        "link": f"https://www.acmicpc.net/problem/{problem_name}" if platform == "백준" else f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_name.split('.')[0]}",
                        "date": get_git_commit_date(file_path),
                        "difficulty": difficulty,
                        "tags": tags,
                        "solved": "✅",
                    }

    return problem_dict

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
    baekjoon_path = os.path.join(repo_path, "백준")
    baekjoon_problems = classify_and_filter_problems(baekjoon_path, "백준")
    baekjoon_text = generate_markdown_by_difficulty(baekjoon_problems, "백준")
    
    programmers_path = os.path.join(repo_path, "프로그래머스")
    programmers_problems = classify_and_filter_problems(programmers_path, "프로그래머스")
    programmers_text = generate_markdown_by_difficulty(programmers_problems, "프로그래머스")
    
    with open(readme_path, "w") as readme_file:
        readme_file.write(readme_template)
        readme_file.write(baekjoon_text)
        readme_file.write(programmers_text)

if __name__ == "__main__":
    update_readme()
