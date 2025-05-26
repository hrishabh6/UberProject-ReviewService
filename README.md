# 📝 Spring Data JPA – Short Notes

This project helped me understand how to use Spring Data JPA effectively. Here's a summary of the concepts and annotations I learned.

---

## 📦 Entity Class - Review.java

```java
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String content;
    
    private double rating;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;
    
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;
}
```

### 🔑 Key Concepts:
* `@Entity`: Marks the class as a JPA entity.
* `@Id`: Specifies the primary key.
* `@GeneratedValue`: Auto-generates the ID (auto-increment).
* `@Column(nullable = false)`: Makes the column NOT NULL.
* `@CreatedDate`, `@LastModifiedDate`: Automatically manage timestamp fields.
* `@EntityListeners(AuditingEntityListener.class)`: Enables auditing for timestamps.
* `@Temporal(TemporalType.TIMESTAMP)`: Sets date precision for SQL storage.

---

## 📁 Repository Layer - ReviewRepository.java

```java
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
```

### 🔍 Key Concepts:
* Inherits from `JpaRepository<T, ID>`, providing:
    * CRUD operations
    * Pagination
    * Sorting
    * Custom queries if needed

---

## ⚙️ Service Layer - ReviewService.java

```java
@Service
public class ReviewService implements CommandLineRunner {
    private ReviewRepository reviewRepository;
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        Review r = Review.builder()
                .content("Amazing ride")
                .rating(5.0)
                .build();
        reviewRepository.save(r);
    }
}
```

### 🚀 Key Concepts:
* `@Service`: Marks it as a service component.
* Implements `CommandLineRunner` to run logic on application startup.
* Uses the builder pattern for object creation.
* Uses `reviewRepository.save()` to persist data to the database.

---

## 🛠️ Configuration for Auditing

```java
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
```

### ⚡ Key Concepts:
* `@EnableJpaAuditing`: Enables auto population of `@CreatedDate` and `@LastModifiedDate` fields.

---

## ✅ Summary

| Layer      | Purpose                                  |
|------------|------------------------------------------|
| Entity     | Maps Java class to DB table              |
| Repository | Provides built-in CRUD operations        |
| Service    | Business logic and interaction with repo |
| Config     | Enables features like auditing           |

This setup is a typical starting point for a Spring Boot + JPA project.

## Inheritance in spring JPA
* `@MappedSuperclass` allows a base class to inherit its properties in child 
class via inheritence in spring jpa (No table created for parent class)

* `@Inheritance(strategy = InheritanceType.SINGLE_TABLE)` makes a single table with all attributes of parent and child class
  (`nullable = false` is not applied here)
* `@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)` same as `@MappedSuperClass` but just makes a dedicated table for Parent class
* `@Inheritance(strategy = InheritanceType.JOINED)` Put common fields in one table (for the parent), and put specific fields of each child class in separate tables. Then link them using IDs.

## Composition in spring
* `@Enumerated(value = EnumType.STRING)` tells that a particular field is an enum and store it as a string in DB
