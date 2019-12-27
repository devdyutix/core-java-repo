package org.dev.design_pattern.abstract_factoryPattern;

abstract class Car{
	abstract void createCar();
}
// implementation class of car 
class SportCar extends Car{

	@Override
	void createCar() {
		System.out.println("Soprt car creqated");
	}
	
}
class NormalCar extends Car{

	@Override
	void createCar() {
		System.out.println("Normal car created");
	}
	
}
// abstractFactory interface
interface CarAbstractFactory{
	abstract Car createCarInstance();
}
//abstactFactory implementation subclasses
class SportCarAbstractFactory implements CarAbstractFactory{

	@Override
	public Car createCarInstance() {
		// TODO Auto-generated method stub
		return new SportCar();
	}
	
}
class NormalCarAbstractFactory implements CarAbstractFactory{

	@Override
	public Car createCarInstance() {
		// TODO Auto-generated method stub
		return new NormalCar();
	}
	
}
// creating factory class
class CarFactory{
	public static Car createCarFromFactory(CarAbstractFactory abstractFactory) {
		return abstractFactory.createCarInstance();
	}
}
public class AbstractFactoryEx {
	public static void main(String[] args) {
		
		Car car=CarFactory.createCarFromFactory(new NormalCarAbstractFactory());
		car.createCar();
	}
}
