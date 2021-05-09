### Spring auto scan components
Add `@Component` annotation to the target class.
```java
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

}
```

In the config class, add `ComponentScan` tag. `basePackages` attribute indicate where to scan the components,
```java
@ComponentScan(basePackages="com.ciaoshen.sia.ch02.soundsystem")
@Configuration
public class CdConfig {}
```

Use `@Autowired` to tell spring to generate instance for you.
```java
public class CdApp {

    @Autowired
    private CompactDisc cd;

}
```

### Make integration test be aware of the spring context
As usual add `useJUnitPlatform()` to run test with junit-jupiter `TestEngine`. Check <https://junit.org/junit5/docs/current/user-guide/#running-tests> for more configuration options.
```groovy
test {
    useJUnitPlatform()
    testLogging {
        events 'passed'
    }
}
```
Use `@ExtendWith(SpringExtension.class)` instead of `@RunWith(SpringJUnit4ClassRunner.class)`, the latter works only for JUnit 4 test. SpringExtension will initialize a spring context in cache. The context is available for all test in this class.
```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CdConfig.class)
public class CdTest {

    @Autowired
    private CompactDisc cd;
    
    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

}
```

###
For the following 2 methods of injecting parameter instance, the first one is better. Because the second one require `SgtPeppers` bean to be defined in `sgtPeppers()` method. For the first method, `CompactDisc` bean can be discovered by component scanning or
declared in XML.

Method 1:
```java
@Bean
public CompactDisc sgtPeppers() {
    return new SgtPeppers();
}
@Bean
public CDPlayer cdPlayer(CompactDisc compactDisc) { // CompactDisc can be defined in a xml config file or auto scaned component
    return new CDPlayer(compactDisc);
}
```

Method 2:
```java
@Bean
public CompactDisc sgtPeppers() {
    return new SgtPeppers();
}
@Bean
public CDPlayer cdPlayer() {
    return new CDPlayer(sgtPeppers());
}
```