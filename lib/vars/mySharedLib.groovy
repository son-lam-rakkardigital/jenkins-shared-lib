import main.groovy.org.example.MySharedLib

def greet(String name) {
    def lib = new MySharedLib()
    def greetingMessage = lib.greet("Jenkins")
    println(greetingMessage)
}