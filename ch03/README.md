### `@Conditional` annotation
In `soundsystem` project, there are three 4 CDs, in 2 categories:
    1. classic music: `Mozart`, `Chopin`
    2. pop music: `Beatles`, `Low Roar`

In `config/CdConfig.java`, `@Conditional(PlayPop.class)` tells spring to call `match()` method in `PlayPop.class`.
```java
@ComponentScan(basePackages="com.ciaoshen.sia.ch03.soundsystem")
@Configuration
public class CdConfig {
    @Bean
    @Profile("dev")
    @Conditional(PlayPop.class)
    public CompactDisc beatles() {
        return new Beatles();
    }

    @Bean
    @Profile("dev")
    @Conditional(PlayClassic.class)
    public CompactDisc chopin() {
        return new Chopin();
    }

    @Bean
    @Profile("prod")
    @Conditional(PlayPop.class)
    public CompactDisc lowroar() {
        return new LowRoar();
    }

    @Bean
    @Profile("prod")
    @Conditional(PlayClassic.class)
    public CompactDisc mozart() {
        return new Mozart();
    }
}
```
`PlayPop.java` will check if the environment's `music-type` property is set to `pop`, otherwise `Beatles` and `Chopin` instance will not be created. So as to `LowRoar` and `Mozart`, they need `music-type` equals `classic`.
```java
public class PlayPop implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.getProperty("music-type").equals("pop");
    }
}
```

The `music-type` property is setted in `@TestPropertySource` annotation. `properties` attribute can accept more than one properties.
```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CdConfig.class)
/* activate "dev" profile */
@ActiveProfiles("dev")
/* set environment property "music-type" to "pop" */
@TestPropertySource(properties = {"music-type = classic"})  
public class CdTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private CdPlayer player;
    
    @Test
    public void shouldPlayChopin() {
        assertNotNull(cd);
        assertEquals(cd.getArtist(), "Chopin");
    }

    @Test
    public void shouldPlayChopin() {
        assertNotNull(player);
    }

}
```

### `@Profile` annotation
`Beatles` and `Chopin` beans will be created only in development profile (`@Profile('dev')`), while the rest `Low Roar` and `Mozart` correspond to produce profile (`@Profile('prod')`). Profile property is also setted in `CdTest.java` class using `@ActiveProfiles("dev")` annotation. Code is shown in last section.

At last, if we set profile to `dev` and `music-type` to `classic`, the only `CompactDisc` bean should be created is `Chopin`. 

### DIY conditional annotation to solve beans ambiguity
We have 4 types of dessert beans in context, `Cake`, `Cookies`, `IceCream` and `Popsicle`. Test class `DessertTest.java` leaves spring to autowire only one of them.
```java
@Autowired
private Dessert dessert;
```

To avoid the beans ambiguity, 4 annotation was created in `annotation/` sub-directory,
    1. `@Cold`
    2. `@Creamy`
    3. `@Crispy`
    4. `@Fruity`
    5. `@Soft`

The following code create `@Cold` annotation,
```java
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Cold {}
```

The DIY annotations are add directly to the `Cake`, `Cookies`, `IceCream` and `Popsicle` class. For example, we describe `IceCream.java` as `@Cold` and `@Creamy`. One the main benefits of DIY annotation over `@Qualifier("cold")` is that it allow us to use more than one annotations to narrow the target down to one specific bean.
```java
@Component
@Cold
@Creamy
public class IceCream implements Dessert {

    public String consumed() {
        return "Ice cream consumed!";
    }

}
```

Here list all beans and their correspondent annotations,
    1. `Cake`: `@Soft`
    2. `Cookies`: `@Crispy`
    3. `IceCream`: `@Cold`, `@Creamy`
    4. `Popsicle`: `@Cold`, `@Fruity`

At last, we annotated the dessert instance with `@Cold` and `@Creamy` annotation. Only `IceCream` meets the definition.
```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DessertConfig.class)
public class DessertTest {

    @Autowired
    @Cold
    @Creamy
    private Dessert dessert;

    @Test
    public void shouldEatIceCream() {
        assertEquals(dessert.consumed(), "Ice cream consumed!");
    }

}
```


