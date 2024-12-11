public class Student {
    private String name;
    private int id;
    private double score; // Thêm điểm của sinh viên

    // Constructor
    public Student(String name, int id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    // Getters và Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // Phương thức để phân loại sinh viên dựa trên điểm số
    public String getRanking() {
        if (score < 5.0) {
            return "Fail";
        } else if (score < 6.5) {
            return "Medium";
        } else if (score < 7.5) {
            return "Good";
        } else if (score < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', score=" + score + ", ranking=" + getRanking() + "}";
    }
}
