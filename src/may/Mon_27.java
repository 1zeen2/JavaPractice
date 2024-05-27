package may;
/*	ElectronicDevice
 * 멤버 변수:
	protected String brand (브랜드)
	protected String model (모델명)
	
	생성자: 브랜드와 모델명을 초기화
	
	추상 메서드:
	public abstract void turnOn() (전원을 켜는 메서드)
	public abstract void turnOff() (전원을 끄는 메서드)
	public abstract void performFunction() (기기를 사용하여 특정 기능을 수행하는 메서드)
	lectronicDevice 클래스를 상속받는 구체 클래스

	Smartphone 클래스
	turnOn() 메서드는 "Smartphone is turning on."을 출력
	turnOff() 메서드는 "Smartphone is turning off."을 출력
	performFunction() 메서드는 "Making a call."을 출력
	Laptop 클래스
	turnOn() 메서드는 "Laptop is booting up."을 출력
	turnOff() 메서드는 "Laptop is shutting down."을 출력
	performFunction() 메서드는 "Running a program."을 출력
	Tablet 클래스
	turnOn() 메서드는 "Tablet is powering on."을 출력
	turnOff() 메서드는 "Tablet is powering off."을 출력
	performFunction() 메서드는 "Browsing the web."을 출력
	메인 클래스

	다양한 전자기기 객체를 생성하고, 각 객체의 메서드를 호출하여 전원을 켜고, 
	기능을 수행하고, 전원을 끄는 작업을 출력하세요.
	
 */
/*
 * 	1. abstract class ElectronicDevice 선언 후 멤버 변수 선언. 생성자를 이용해 초기화한 후 추상 메서드를 생성합니다.
 * 	2. 각 하위 클래스는 상위 클래스로부터 상속을 받고, 추상 메서드를 통해 기능을 부여받을 수 있도록 한다.
 * 	3. 추상 메서드 하나로 여러 클래스에서 동작을 구현해야 하기 때문에 Method Overriding 을 해준다.
 * 	4. Main Method 에서 객체 생성 후, 메서드를 통하여 기능을 구현한다. (클래스타입 변수명 클래스명 매개변수)
 */
abstract class ElectronicDevice {
	protected String brand;
	protected String model;
	
	public ElectronicDevice (String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public abstract void turnOn();
	
	public abstract void turnOff();
	
	public abstract void performFunction();
}

class Smartphone extends ElectronicDevice {
	public Smartphone (String brand, String model) {
		super(brand, model);
	}

	@Override
	public void turnOn() {
		System.out.println("Smartphone is turning on.");
	}

	@Override
	public void turnOff() {
		System.out.println("Smartphone is tur off.");
		
	}

	@Override
	public void performFunction() {
		System.out.println("Making a call.");
	}
	
}

class Laptop extends ElectronicDevice {
	public Laptop(String brand, String model) {
		super(brand, model);
	}

	@Override
	public void turnOn() {
		System.out.println("Laptop is booting up.");
	}

	@Override
	public void turnOff() {
		System.out.println("Laptop is Shutting down.");
	}

	@Override
	public void performFunction() {
		System.out.println("Running a Program.");
	}
	
}

class Tablet extends ElectronicDevice {
	public Tablet (String brand, String model) {
		super(brand, model);
	}

	@Override
	public void turnOn() {
		System.out.println("Tablet is Powering on.");
	}

	@Override
	public void turnOff() {
		System.out.println("Table is powering off.");
	}

	@Override
	public void performFunction() {
		System.out.println("Browsing the web.");
	}
	
}


public class Mon_27 {

	public static void main(String[] args) {
		ElectronicDevice smart = new Smartphone("Iphone", "14");
		ElectronicDevice laptop = new Laptop("MacBook","Air");
		ElectronicDevice tablet = new Tablet("Ipad","14");
		
		smart.turnOn();
		smart.turnOff();
		smart.performFunction();
		
		laptop.turnOn();
		laptop.turnOff();
		laptop.performFunction();
		
		tablet.turnOn();
		tablet.turnOff();
		tablet.performFunction();
		
	}

}
