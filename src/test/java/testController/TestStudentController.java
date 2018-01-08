package testController;

import com.thanh.controller.StudentController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TestStudentController {
    private MockMvc mockMvc;

    @Before
    public void setup() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new StudentController())
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void testReadPage() throws Exception {
        mockMvc.perform(get("/read"))
                .andExpect(status().isOk())
                .andExpect(view().name("read"))
                .andExpect(forwardedUrl("/WEB-INF/views/read.jsp"));
    }

    @Test
    @Ignore
    public void testUploadPage() throws Exception {
        mockMvc.perform(get("/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("upload"))
                .andExpect(forwardedUrl("/WEB-INF/views/upload.jsp"));
    }
}
