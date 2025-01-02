import os

# 저장소 경로와 README 파일 경로 설정
repo_path = "./"  # 저장소 루트 경로
readme_path = os.path.join(repo_path, "README.md")

# README 헤더 템플릿
readme_template = """
# 알고리즘 저장소 📚

이 저장소는 백준 온라인 저지와 프로그래머스에서 해결한 알고리즘 문제 풀이를 모아둔 공간입니다. 🚀

---

## 📝 해결한 문제들

| **카테고리** | **문제** | **난이도** | **풀이 날짜** | **해결 여부** |
|--------------|----------|------------|---------------|---------------|
"""

# 문제 목록 생성
def generate_problem_list(base_path, platform):
    problem_list = []
    
    for root, dirs, files in os.walk(base_path):
        for file in files:
            if file.endswith(".md") or file.endswith(".py") or file.endswith(".java"):  # 문제 파일 필터링
                # 파일 경로 및 카테고리 추출
                category = os.path.basename(root)
                rel_path = os.path.relpath(os.path.join(root, file), repo_path)
                
                # 난이도 및 링크 설정
                problem_name = os.path.splitext(file)[0]
                link = f"https://www.acmicpc.net/problem/{problem_name}"  # 기본적으로 백준 문제 링크
                level_icon = "https://static.solved.ac/tier_small/1.svg"  # 예시로 난이도 아이콘 설정
                
                # 문제 추가
                problem_list.append({
                    "category": category,
                    "name": problem_name,
                    "link": link,
                    "level_icon": level_icon,
                    "date": "YYYY-MM-DD",  # 여기에 풀이 날짜를 수동으로 넣거나, 파일 생성 날짜를 이용해 자동화 가능
                    "solved": "O"  # 해결 여부, O 또는 X
                })
    
    # 문제 텍스트 생성
    problem_text = ""
    for problem in problem_list:
        problem_text += f"| {problem['category']} | [{problem['name']}]({problem['link']}) | <img height='25px' width='25px' src='{problem['level_icon']}'/> | {problem['date']} | {problem['solved']} |\n"
    
    return problem_text

# README 업데이트
def update_readme():
    # 백준 문제 목록
    baekjoon_path = os.path.join(repo_path, "백준")
    baekjoon_problems = generate_problem_list(baekjoon_path, "백준")
    
    # 프로그래머스 문제 목록
    programmers_path = os.path.join(repo_path, "프로그래머스")
    programmers_problems = generate_problem_list(programmers_path, "프로그래머스")
    
    # README 생성
    with open(readme_path, "w") as readme_file:
        readme_file.write(readme_template)
        readme_file.write(baekjoon_problems)
        readme_file.write(programmers_problems)

if __name__ == "__main__":
    update_readme()
