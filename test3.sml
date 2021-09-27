class MainClass
{
	def main(): int{
		writeln((new SecondClass()).test());
		writeln((new FifthClass()).test2());
		return 23;
	}
}
class SecondClass{
	def test():string{
		return "ye ace\n";
	}
	def test2(x: boolean): boolean{
		var z: boolean; 
		var y: boolean;
		z = false;
		if(true) then
			z = true;
		if(!z) then
			z = true;
		else
			z = false;
		return z;
	}
}
class FourthClass{
	def test():int{
		var x: int;
		var y: int;
		return 0;
	}
}
class FifthClass{
	var instance1: FourthClass;
	def test2(): int{
		var x: int; 
		var y: int;
		var z: FourthClass;
		instance1 = new FourthClass();
		x = instance1.test();
		return x;
	}
}
class Round1 extends FifthClass{
	var test : int;
}