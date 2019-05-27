import org.junit.*;
                            // Проверки в JUnit (Assert)
public class MainClassTest {
//
//    @BeforeClass     //метод для подготовки тестовой среды для использ. методов
//    public void beforeClassMethod(){
//
//    }
//
//    @Before            //метод, который будет запускатся перед каждым тестовым методом
//    public void setUp (){
//
//    }

    @Test     //метод, для выполнения теста
    public void method1(){
        Assert.assertTrue("Value are not equals",1 + 1 == 2); //успешный тест, если условие ассерта выполниться - проверка
//        Assert.assertFalse(1 + 1 == 10);

    }

//    @Test     //метод, для выполнения тест
//    @Ignore   // анотация позволяет игнорировать тест
//    public void method2(){
//        Assert.assertNull();
//        Assert.assertNotNull();
//
//
//    }

    @Test      //метод, для выполнения тестa
    public void method2(){
        Assert.assertEquals(20, 5 + 5);
//        Assert.assertNotEquals(10, 2 + 2);

    }

//    @After        //метод, который будет запускатся пссле каждого тестового метода
//    public void tearDown(){
//
//    }
//
//    @AfterClass                // анотация    ..метод после выполнения всех методов
//    public void AfterClassMethod(){
//
//    }
    @Test
    public void method3(){
        Assert.assertFalse("Value are equals",1 + 1 == 2);
    }
    @Test
    public void method4(){
            Assert.assertNotEquals(20, 5 + 5);
    }
}
