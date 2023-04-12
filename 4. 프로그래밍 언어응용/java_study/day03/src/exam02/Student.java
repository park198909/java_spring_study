package exam02;

public class Student {
    int id;             // 학번
    String name;        // 이름
    String subject;     // 과목

    public Student(){       // 생성자함수
        // 반환값 설정 불가
        // 변수 초기화 설정 가능
        // 객체 주소값 반환 후 실행할 코드 입력가능
        id = 1000;
        name = "이름1";
        subject = "과목1";
    }

    public Student(int _id, String _name, String _subject){     // 생성자 오버로드
        id = _id;
        name = _name;
        subject = _subject;
    }

//    void study(){
//        System.out.println(subject+"를 공부한다.");
//    }
    void showInfo(){
        System.out.println("id="+id+", name="+name+", subject="+subject);
    }
}
