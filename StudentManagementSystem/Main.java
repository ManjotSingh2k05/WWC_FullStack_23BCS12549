import java.util.*;

class Student{
    private String id, name;
    private int marks;
    public Student(String id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public String getId(){ return id; }
    public int getMarks(){ return marks; }
    public String getRole(){ return "undergrad"; }
    public String report(){
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Role: " + getRole();
    }
    @Override
    public String toString(){
        return id + " " + name + " ( " + marks + " ) " + getRole();
    }
    public void getInfo(){
        System.out.println(id + " " + name + " " + marks + getRole());
    }
}

class GraduateStudent extends Student{
    private String area;
    public GraduateStudent(String id, String name, int marks, String area){
        super(id,name,marks);
        this.area = area;
    }
    @Override
    public String getRole(){
        return "Grad(" + area + ")";
    }
}

class Teacher{
    private String id, name, teachingSubject;
    public Teacher(String id, String name, String teachingSubject){
        this.id = id;
        this.name = name;
        this.teachingSubject = teachingSubject;
    }
    public String getId(){ return id; }
    @Override
    public String toString(){
        return id + " " + name + " Teacher(" + teachingSubject + ")";
    }
}

class Repository<T>{
    private Map<String, T> data = new HashMap<>();
    public void save(String id, T obj){
        data.put(id,obj);
    }
    public T find(String id){
        return data.get(id);
    }
    public void delete(String id){
        data.remove(id);
    }
}

class Main{
    public static void teach(){
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("t1","MD","DSA"));
        Repository<Teacher> repo = new Repository<>();
        for(Teacher t: teacherList) repo.save(t.getId(),t);
        teacherList.forEach(System.out::println);
    }

    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("s1","Tarak",90));
        list.add(new Student("s2","Gurvir",56));
        list.add(new Student("s3","Raj",78));
        list.add(new GraduateStudent("G1","Arsh",99,"CSE"));
        Repository<Student> repo = new Repository<>();
        for(Student s: list) repo.save(s.getId(),s);
        list.forEach(System.out::println);

        System.out.println("\nReport for s1");
        System.out.println(repo.find("s1").report());

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student st = it.next();
            if(st.getMarks() < 80){
                it.remove();
                repo.delete(st.getId());
            }
        }

        System.out.println("\nAfter removing students below 80");
        list.forEach(System.out::println);

        teach();
    }
}
