package testPersistence;

import com.thanh.Exercise1.Student;
import com.thanh.persistence.StudentDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestStudentPersistence extends BaseTester {
    private StudentDao studentDao;

    @Before
    public void setUp() {
        super.setUp();
        studentDao = new StudentDao();
    }

    @Test
    public void testInsert() {
        ArrayList<Student> students = new ArrayList<Student>();
        Student student = new Student();

        student.setFirstName("Thanh");
        student.setLastName("Nguyen");
        student.setEmail("thanhnt.uit@gmail.com");
        student.setBirthDay("17/10/1995");

        students.add(student);

        studentDao.create(students);

        ArrayList<Student> students1 = studentDao.read();
        Student other = students1.get(0);

        Assert.assertEquals(other.getFirstName(), student.getFirstName());
        Assert.assertEquals(other.getLastName(), student.getLastName());
        Assert.assertEquals(other.getEmail(), student.getEmail());
        Assert.assertEquals(other.getBirthDay(), student.getBirthDay());

        Assert.assertTrue(students1.size() == 1);

    }
}
