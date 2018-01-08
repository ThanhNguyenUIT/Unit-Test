package testService;

import com.thanh.Exercise1.Student;
import com.thanh.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testPersistence.BaseTester;

import java.util.ArrayList;

public class TestStudentService extends BaseTester {
    private StudentService studentService;

    @Before
    public void setUp() {
        super.setUp();
        studentService = new StudentService();
    }

    @Test
    public void testProcess() {
        ArrayList<Student> students = new ArrayList<Student>();
        Student student = new Student();

        student.setFirstName("Thanh");
        student.setLastName("Nguyen");
        student.setEmail("thanhnt.uit@gmail.com");
        student.setBirthDay("17/10/1995");

        students.add(student);

        studentService.process(students);

        ArrayList<Student> students1 = studentService.get();
        Student other = students1.get(0);

        Assert.assertEquals(other.getFirstName(), student.getFirstName());
        Assert.assertEquals(other.getLastName(), student.getLastName());
        Assert.assertEquals(other.getEmail(), student.getEmail());
        Assert.assertEquals(other.getBirthDay(), student.getBirthDay());

        Assert.assertTrue(students1.size() == 1);

    }
}
