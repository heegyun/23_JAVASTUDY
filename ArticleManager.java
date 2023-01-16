package day_07;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleManager {

    public static void main(String[] args) {
        System.out.println("==프로그램 시작==");

        Scanner sc = new Scanner(System.in);
        // 게시글 count 하는 변수
        int lastArticleId = 0;

        // 게시물 관리하는 자료구조
        List<Article> articleList = new ArrayList<Article>();

        while (true) {
            System.out.printf("명령어 ) ");
            String command = sc.nextLine();

            if (command.length() == 0){
                System.out.println("명령어를 입력해 주세요");
                continue;
            }

            if (command.equals("exit")) {
                break;
            }

            if (command.equals("write")) {
                int id = lastArticleId + 1;
                lastArticleId = id;
                System.out.printf("제목 : ");
                String title = sc.nextLine();
                String regDate = Util.getNowDateStr();
                System.out.printf("내용 : ");
                String body = sc.nextLine();

                ///////////////////////////////////////////////////
                Article article = new Article(id, title, regDate,body);
                articleList.add(article);
                //////////////////////////////////////////////////

                System.out.printf("%d 번글이 생성되었습니다\n", id);

            } else if (command.equals("list")) {
                if (articleList.size() == 0) {
                    System.out.println("게시글이 없습니다");
                    continue;
                }
                System.out.println("번호 |  제목");
                for (int i = articleList.size() - 1; i >= 0; i--) {// 최근 글이 먼저 시작 하도록
                    Article article = articleList.get(i);
                    System.out.printf("%d   |   %s\n", article.id, article.title);
                }
            } else if(command.startsWith("detail ")) { // 게시글 1번 상세보기 예) detail 1

                String[] cmdNum = command.split(" "); // 문자열에서 공백을 기준으로 숫자와 분리하기.
                int id = Integer.parseInt(cmdNum[1]); // 분리한 후 배열에 넣고, 1인덱스에 있는 문자열 꺼내 숫자로바꿈

                Article foundArticle = null;

                for (int i = 0; i < articleList.size(); i++) {
                    Article article = articleList.get(i);

                    if (article.id == id) {
                        foundArticle = article; // 상세하게 볼 해당 게시물이 있다..
                        break;
                    }
                }

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                System.out.printf("번호: %d\n", foundArticle.id);
                System.out.printf("날짜: %s\n", foundArticle.regDate);
                System.out.printf("제목: %s\n", foundArticle.title);
                System.out.printf("내용: %s\n", foundArticle.body);

            } else if(command.startsWith("modify ")){ // 게시물 수정
                String[] commandBits = command.split(" ");

                int id = Integer.parseInt(commandBits[1]);

                Article foundArticle = null;

                for (int i = 0; i < articleList.size(); i++) {
                    Article article = articleList.get(i);

                    if (article.id == id) {
                        foundArticle = article;
                        break;
                    }
                }
                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String body = sc.nextLine();

                foundArticle.title = title;
                foundArticle.body = body;

                System.out.printf("%d번 게시물을 수정했습니다.\n", id);


            } else if(command.startsWith("delete ")) {// 게시물 삭제
                String[] commandBits = command.split(" ");
                int id = Integer.parseInt(commandBits[1]); // "1" -> 1

                int foundIndex = -1;

                for (int i = 0; i < articleList.size(); i++) {
                    Article article = articleList.get(i);

                    if (article.id == id) {
                        foundIndex = i;
                        break;
                    }
                }

                if (foundIndex == -1) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                articleList.remove(foundIndex);

                System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
            } else {
                    System.out.println("존재하지 않는 명령어 입니다");
            }
        }

        sc.close();

        System.out.println("==프로그램 끝==");

        // write: 글쓰기 기능
        // list: 글 목록 기능

    }
}

class Article {
    int id;
    String title;
    String body;
    String regDate;

    public Article(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Article(int id, String title, String regDate, String body){
            this.id = id;
            this.title = title;
            this.regDate = regDate;
            this.body = body;
        }
    }
