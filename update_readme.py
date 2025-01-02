import os
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

# 파일 생성 날짜 가져오기
def get_file_creation_date(file_path):
    timestamp = os.path.getmtime(file_path)  # 파일 수정 시간 기준
    return datetime.fromtimestamp(timestamp).strftime("%Y-%m-%d")

# 문제 목록 생성
def classify_and_filter_problems(base_path, platform):
    problem_dict = {}  # 문제 중복 제거를 위한 딕셔너리

    for root, dirs, files in os.walk(base_path):
        for file in files:
            if file.endswith(".md") or file.endswith(".py") or file.endswith(".java"):  # 문제 파일 필터링
                # 문제 이름 및 파일 경로
                problem_name = os.path.splitext(file)[0]
                file_path = os.path.join(root, file)

                # 문제 번호(백준) 또는 ID(프로그래머스)를 키로 사용
                problem_key = problem_name

                # 중복 확인
                if problem_key not in problem_dict:
                    problem_dict[problem_key] = {
                        "name": problem_name,
                        "link": f"https://www.acmicpc.net/problem/{problem_name}" if platform == "백준" else f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_name}",
                        "date": get_file_creation_date(file_path),
                        "solved": "O",
                    }

    return problem_dict

# 난이도별 문제 텍스트 생성
def generate_markdown_by_difficulty(problem_dict, platform):
    problem_text = f"### 📌 {platform}\n\n"
    problem_text += "| **문제** | **풀이 날짜** | **해결 여부** |\n"
    problem_text += "|----------|---------------|---------------|\n"

    for problem in problem_dict.values():
        problem_text += f"| [{problem['name']}]({problem['link']}) | {problem['date']} | {problem['solved']} |\n"

    problem_text += "\n"
    return problem_text

# README 업데이트
def update_readme():
    # 백준 문제 목록 생성
    baekjoon_path = os.path.join(repo_path, "백준")
    baekjoon_problems = classify_and_filter_problems(baekjoon_path, "백준")
    baekjoon_text = generate_markdown_by_difficulty(baekjoon_problems, "백준")
    
    # 프로그래머스 문제 목록 생성
    programmers_path = os.path.join(repo_path, "프로그래머스")
    programmers_problems = classify_and_filter_problems(programmers_path, "프로그래머스")
    programmers_text = generate_markdown_by_difficulty(programmers_problems, "프로그래머스")
    
    # README 생성
    with open(readme_path, "w") as readme_file:
        readme_file.write(readme_template)
        readme_file.write(baekjoon_text)
        readme_file.write(programmers_text)

if __name__ == "__main__":
    update_readme()
