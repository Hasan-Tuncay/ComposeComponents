import java.time.LocalDateTime

// An interface definition
interface Person {
    fun greet(): String
}

// A data class that implements an interface and contains a high-order function
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val processMessage: (String) -> String = { it.toUpperCase() } // A high-order function as a default parameter
) : Person {
    // Implementing the interface method
    override fun greet() = "Hello, my name is $firstName $lastName"

    // A secondary constructor
    constructor(firstName: String, email: String) : this(firstName, "Not Specified", email)

    // A function to return the full name
    fun fullName(): String = "$firstName $lastName"
}

// A data class for posts
data class Post(val user: User, val content: String, val creationTime: LocalDateTime = LocalDateTime.now())

// A data class for comments
data class Comment(val user: User, val post: Post, val content: String, val creationTime: LocalDateTime = LocalDateTime.now())

fun main() {
    val user1 = User("John", "Doe", "john@example.com")
    val user2 = User("Jane", email = "jane@example.com") // Using the secondary constructor

    val post1 = Post(user1, "This is my first post!")
    val post2 = post1.copy(user = user2, content = "I'm here too!")

    // Equality check and using hashCode
    println(user1 == User("John", "Doe", "john@example.com")) // Outputs: true
    val userSet = hashSetOf(user1, user2)
    println(userSet.contains(User("John", "Doe", "john@example.com"))) // Outputs: true

    val comment1 = Comment(user2, post1, "Great post!")
    println(comment1)

    // Using the interface method and a custom function
    println(user1.greet())
    println(user1.fullName())

    // Demonstration of high-order function usage
    println("Processed message: ${user1.processMessage("hello world")}")
}
