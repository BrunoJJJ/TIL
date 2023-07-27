Data Type & Operator
--------------------

```java
class MyInfo {
    public static void main(String[] args) {
        String name = "Bruno";
        short birthYear = 1998;
        short birthMonth = 01;
        short birthDay = 20;
        int scoreCheckin = 8;
        boolean devExp = false;
        
        
        
        System.out.println("name = " + name);
        System.out.printf("my birth is %d year, %02d mon, %d day.\n", birthYear, birthMonth, birthDay);
        System.out.printf(String.format("my birth is %d year, %02d mon, %d day.\n", birthYear, birthMonth, birthDay));
        System.out.println("score_checkin = " + scoreCheckin);
        System.out.println("develop_experience = " + devExp);
    }
}
```
Condition/Iteration
-------------------
### condition
```java
class NumDivision {
    public static void main(String[] args) {
        int n = -5;
        int age = 26;
        
        if (n > 0) {
            System.out.printf("%d : positive number\n", n);
        } else if (n < 0) {
            System.out.printf("%d : negative number\n", n);
        } else {
            System.out.println("zero");
        }
        
        if (age >= 19) {
            System.out.printf("%d age : adult\n", age);
        } else {
            System.out.printf("%d age : kid\n", age);
        }

        // 삼항 연산자 이용 (가독성 up, 중첩 시 역효과)
        //String ageType = (age > 19) ? "adult" : "kid";
        //System.out.printf("%d age : %s\n", age, ageType);
        
    }
}
```
삼항 연산자는 조건에 따라 값을 다르게 주려고 할 경우
ex) int a = (c == korea) ? (age + 1) : age;

### Iteration
```java
class Iteration {

  public static void main(String[] args) {
    //odd, even, 4step ..
    for (int i = 0; i < 100; i += 4) {
        System.out.println(i);
    }
    
    for (int i = 100; i > 0; i -= 4) {
        System.out.println(i);
    }
    
  }
}
```

### Game369
```java

class Game369 {

    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {
            if (i < 10) {
                if (i % 3 == 0) {
                    System.out.println("clap");
                } else {
                    System.out.println(i);
                }

            } else if (10 <= i && i < 100) {
                int j = i % 10; //1st position (n / 10^(k-1) % 10)
                int k = i / 10; //2st position

                if (j != 0 && j % 3 == 0 && k % 3 != 0) {
                    System.out.println("clap");

                } else if (j != 0 && k % 3 == 0 && j % 3 != 0) {
                    System.out.println("clap");

                } else if (j == 0 && k % 3 == 0) {
                    System.out.println("clap");

                } else if (j != 0 && j % 3 == 0 && k % 3 == 0) {
                    System.out.println("clap clap");

                } else {
                    System.out.println(i);
                }

            } else {
                System.out.println(i);
            }

        }
    }
}
```

### switch 이용
```java
class Game369 {

  public static void main(String[] args) {
    
    for (int i = 1; i < 101; i++) {
      int clap = 0;
      int j = i % 10; // 1st position
      int k = i / 10; // 2st position

      if (j != 0 && j % 3 == 0) {
        clap++;
      }
      if (k != 0 && k % 3 == 0) {
        clap++;
      }

      switch (clap) {
        case 2:
          System.out.println(clap + "claps");
          break;

        case 1:
          System.out.println(clap + "clap");
          break;

        default:
          System.out.println(i);
      }
    }
  }
}
```
cf. j ≠ 0 없으면 일의자리가 0인 경우, 박수를 침. j == 0인 조건이 없으면 30 60 90에 박수를 안침.



JAVA Class(Field, Constructor, Method)
--------------------------------------
```java
class Person {
    // field
    String name;
    String adress;
    int age;
    int height;
    int weight;
    final String bloodType;

    // constructor
    Person(String name, String adress, int age, int height, int weight, String bloodType) {
        this.name = name;
        this.adress = adress;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
    }
    
    //method
    public void printInfo() {
        System.out.println("name : " + name);
        System.out.println("adress : " + adress);
        System.out.println("age : " + age);
        System.out.println("height : " + height);
        System.out.println("weight : " + weight);
        System.out.println("bloodType : " + bloodType);
    } 


}

class HelloWorld {
    public static void main(String[] args) {
        Person person1 = new Person("bruno", "seoul", 10, 162, 50, "A");
        person1.printInfo();
    }
}
```

### Class Product
```java
class HelloWorld {
    public static void main(String[] args) {
        Product apple = new Product("apple", "fresh", 4000, 3, 0.3, true);
        apple.purchase();
        System.out.println(apple.priceCalc());
    
    }
}

class Product {
    // field
    String name;
    String description;
    int price;
    int remain_stuff;
    double dcRate;
    boolean hasProduct;

    // constructor
    Product(String name, String description, int price, int remain_stuff, double dcRate, boolean hasProduct) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.remain_stuff = remain_stuff;
        this.dcRate = dcRate;
        this.hasProduct = hasProduct;
    }
    
    //method
    public void purchase() {
        if (hasProduct) {
            System.out.printf("this %s is %s. %d won\n", name, description, price);
            remain_stuff--;
            System.out.printf("remain_stuff : %d\n", remain_stuff);
        }
    }
    
    public double priceCalc() {
        return price * (100 - dcRate * 100) / 100;
    }

    public void fill() {
        remain_stuff++;
        System.out.printf("remain_stuff : %d\n", remain_stuff);
    }

}
```

### enum 활용
```java
enum Models {BMW, KIA, CHEVROLET} //switch와 함께 주로

class Main {
    public static void main(String[] args) {
   
        Car car1 = new Car(Models.BMW, "black", -1, 0);
        car1.setSpeed();
        car1.getSpeed();
        car1.increaseSpeed();
        car1.getGas(3);
    }
}

class Car {
    //field
    Models model; // enum 
    String color;
    int speed;
    double gas; // 
    final int gasPrice1L = 1600;
    int liter = 0;

    //costructor
    Car(Models model, String color, int speed, double gas) {
        this.model = model;
        this.color = color;
        this.speed = speed;
        this.gas = gas;
    }

    //method
    public void setSpeed() {
        if (speed < 0) {
            this.speed = 0;
            return;
        }
        else {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        System.out.printf("Current speed is %d\n", speed);
        return speed;
    }

    public int increaseSpeed() {
        if (model == Models.BMW) 
        this.speed = ++speed;
        System.out.printf("Current speed is %d\n", speed);
        return speed;
    }


    public double getGas(int liter) {
            System.out.printf("I want to fuel up. %dL\n", liter);
            System.out.printf("The fuel cost is %d\n", liter * gasPrice1L);
            this.gas = gas + liter;
            return gas;
        }
    }
```
cf. setter, getter
