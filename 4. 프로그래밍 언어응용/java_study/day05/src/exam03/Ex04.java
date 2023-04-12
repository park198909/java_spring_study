package exam03;

public class Ex04 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        Human human = new Human();
        human.move();

        Dog dog = new Dog();
        dog.move();

        Bird bird = new Bird();
        bird.move();
    }
}
