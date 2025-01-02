import os
import subprocess
from datetime import datetime

repo_path = "./"  # 저장소 루트 경로
readme_path = os.path.join(repo_path, "README.md")

readme_template = """
# 알고리즘 저장소 📚

백준 온라인 저지와 프로그래머스에서 해결한 알고리즘 문제 풀이를 모아둔 공간입니다! 🚀

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
        return result.stdout.strip().split(" ")[0]  # 날짜 부분만 추출
    except Exception as e:
        print(f"Git 커밋 날짜 오류: {e}")
        return "Unknown"

# 수동 태그 관리
def get_manual_tags(problem_number, platform):
    manual_tags = {
        "백준": {
            "11720": "수학, 구현",
            "1546": "수학, 구현",
            "2750": "정렬",
            "1253": "이분 탐색",
            "11003": "데크, 슬라이딩 윈도우",
        },
        "프로그래머스": {
            "12906": "스택, 큐",
            "42586": "스택, 큐, 구현",
        },
    }
    return manual_tags.get(platform, {}).get(problem_number, "미분류")

# 문제 데이터 추출
def extract_problem_data(root, folder_name, platform):
    try:
        if platform == "백준":
            difficulty = os.path.basename(root)  # 난이도 (Bronze, Silver 등)
            problem_number, problem_name = folder_name.split(".")
            return problem_number.strip(), problem_name.strip(), difficulty
        elif platform == "프로그래머스":
            level = os.path.basename(root)  # Level 1, Level 2
            problem_number, problem_name = folder_name.split(".")
            return problem_number.strip(), problem_name.strip(), f"Level {level}"
    except Exception as e:
        print(f"문제 데이터 추출 오류: {e}")
        return None, None, "Unknown"

# 문제 분류 및 필터링
def classify_and_filter_problems(base_path, platform):
    problem_dict = {}
    if not os.path.exists(base_path):
        print(f"경로가 존재하지 않습니다: {base_path}")
        return problem_dict

    for root, dirs, _ in os.walk(base_path):
        for folder in dirs:
            folder_path = os.path.join(root, folder)
            problem_number, problem_name, difficulty = extract_problem_data(root, folder, platform)

            if not problem_number:
                continue

            files_in_folder = os.listdir(folder_path)
            if not files_in_folder:
                continue
            file_path = os.path.join(folder_path, files_in_folder[0])

            problem_dict[problem_number] = {
                "name": problem_name,
                "link": f"https://www.acmicpc.net/problem/{problem_number}" if platform == "백준" else f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_number}",
                "date": get_git_commit_date(file_path),
                "difficulty": difficulty,
                "tags": get_manual_tags(problem_number, platform),
                "solved": "✅",
            }

    return problem_dict

# 난이도별 마크다운 생성
def generate_markdown_by_difficulty(problem_dict, platform):
    problem_text = f"### 📌 {platform}\n\n"
    difficulty_levels = ["Bronze", "Silver", "Gold", "Platinum", "Level 1", "Level 2", "Level 3"]

    for level in difficulty_levels:
        problems = [p for p in problem_dict.values() if p["difficulty"] == level]
        if problems:
            problem_text += f"#### {level}\n"
            problem_text += "| **문제 번호** | **문제 이름** | **분류** | **풀이 날짜** | **해결 여부** |\n"
            problem_text += "|---------------|--------------|----------|---------------|---------------|\n"
            for problem_number, problem in sorted(problem_dict.items()):
                if problem["difficulty"] == level:
                    problem_text += f"| {problem_number} | [{problem['name']}]({problem['link']}) | {problem['tags']} | {problem['date']} | {problem['solved']} |\n"
            problem_text += "\n"

    return problem_text

# README 업데이트
def update_readme():
    baekjoon_path = os.path.join(repo_path, "백준")
    programmers_path = os.path.join(repo_path, "프로그래머스")

    baekjoon_problems = classify_and_filter_problems(baekjoon_path, "백준")
    programmers_problems = classify_and_filter_problems(programmers_path, "프로그래머스")

    baekjoon_text = generate_markdown_by_difficulty(baekjoon_problems, "백준")
    programmers_text = generate_markdown_by_difficulty(programmers_problems, "프로그래머스")

    with open(readme_path, "w") as readme_file:
        readme_file.write(readme_template)
        readme_file.write(baekjoon_text)
        readme_file.write(programmers_text)

if __name__ == "__main__":
    update_readme()
