Design Notes – Tutorial 7

(a) Modularity: I used dependency inversion in `ProductService.java`. The service depends on the `ProductRepository`
interface instead of directly depending on `InMemoryProductRepository`. This means the service knows what operations are
available, such as `findAll`, `findById`, `save`, and `delete`, but does not need to know how the data is stored.

(b) Testability: Both `ProductController` and `ProductService` receive their dependencies through constructors. This
makes testing easier because I can pass a fake or mocked `ProductRepository` into `ProductService` and check whether
`getProductById(999L)` throws a `ProductNotFoundException`. This was harder in Lecture 6 because Spring used
`@Autowired` to inject dependencies into private fields, and the service created its own `ArrayList`.

(c) The swap test: If I wanted to use a database instead of in-memory storage, I could create a new class that
implements the `ProductRepository` interface. I would only need to replace `InMemoryProductRepository`, which currently
uses a `HashMap` and a `nextId` counter. I would not need to change anything in `ProductService.java` or
`ProductController.java` because both depend on the interface rather than the actual storage implementation.