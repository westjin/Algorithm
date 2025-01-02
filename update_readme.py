import os

# 저장소 경로와 README 파일 경로 설정
repo_path = "./"  # 저장소 루트 경로
readme_path = os.path.join(repo_path, "README.md")

# README 헤더 템플릿
readme_template = """
# Algorithm Repository 📚

This repository contains solutions for algorithm problems solved on Baekjoon Online Judge and Programmers. 🚀

---

## 📝 Solved Problems

### 📌 Baekjoon Problems
"""

# 문제 목록 생성
def generate_problem_list(base_path, platform):
    problem_dict = {}
    
    for root, dirs, files in os.walk(base_path):
        for file in files:
            if file.endswith(".md") or file.endswith(".py") or file.endswith(".java"):  # 문제 파일 필터링
                rel_path = os.path.relpath(root, base_path)
                difficulty = rel_path.split("/")[-1]  # 난이도 디렉토리명
                if difficulty not in problem_dict:
                    problem_dict[difficulty] = []
                problem_dict[difficulty].append(f"- [{file}]({os.path.join(rel_path, file)})")
    
    # 정렬 및 텍스트 생성
    problem_text = f"### {platform}\n"
    for difficulty, problems in sorted(problem_dict.items()):
        problem_text += f"#### {difficulty}\n"
        problem_text += "\n".join(problems) + "\n\n"
    
    return problem_text

# README 업데이트
def update_readme():
    # Baekjoon 문제 목록
    baekjoon_path = os.path.join(repo_path, "백준")
    baekjoon_problems = generate_problem_list(baekjoon_path, "Baekjoon")
    
    # Programmers 문제 목록
    programmers_path = os.path.join(repo_path, "프로그래머스")
    programmers_problems = generate_problem_list(programmers_path, "Programmers")
    
    # README 생성
    with open(readme_path, "w") as readme_file:
        readme_file.write(readme_template)
        readme_file.write(baekjoon_problems)
        readme_file.write(programmers_problems)

if __name__ == "__main__":
    update_readme()
