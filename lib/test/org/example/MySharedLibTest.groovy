package org.example

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

class MySharedLibTest extends BasePipelineTest {

    @Test
    void testGreetFunction() {
        // Mock the echo step used in MySharedLib
        helper.registerAllowedMethod('echo', [String]) { message ->
            println "Mocked echo: $message"
            return message
        }

        // Instantiate the class and call the method
        def lib = new MySharedLib()
        def result = lib.greet('Jenkins')

        // Validate behavior
        assertNotNull(result)
        // println(result)
        // assertCallStackContains("Hello, Jenkins!")
        assertEquals("Hello, Jenkins!", result)
    }
}