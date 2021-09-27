class Main
{
        def main(): int
        {
                return 0;
        }
}
class Tool{
	def print(a : int[]):int
	{
		var i : int;
		i=0;
		writeln("[");
		while(i<a.length){
			writeln(a[i]);
			writeln(",");
			i = i+1;
		}
		writeln("]\n");
		return 0;
	}
}
