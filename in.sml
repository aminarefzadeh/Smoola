class Main
{
        def main(): int
        {
                writeln("#### Equality Test ####");

                if (!false) then {
                       writeln("not, test 1 , pass"); 
                }

                if (!0) then {
                       writeln("not, test 2 , pass"); 
                }

                if (!true) then {} else {
                       writeln("not, test 3 , pass"); 
                }

                if (!(2 + 3 - 5 + 17)) then {} else {
                       writeln("not, test 4 , pass"); 
                }

                if(true == true) then
                        writeln("if: eqtest: eq");
                else
                        writeln("Nothing!");  

                writeln("#### Non-equality Test ####");

                if(true <> false) then
                        writeln("if: neqtest: neq");
                else
                        writeln("Nothing!");

                writeln("#### Less than Test ####");

                if(0 < 1) then
                        writeln("if: lttest: lt");
                else
                        writeln("Nothing!");

                if(1 < 0) then
                        writeln("Nothing!");
                else
                        writeln("else: lttest: gt");

                writeln("#### Greater than Test ####");

                if(1 > 0) then
                        writeln("if: gttest: gt");
                else
                        writeln("Nothing!");

                if(0 > 1) then
                        writeln("Nothing!");
                else
                        writeln("else: gttest: lt");

                writeln("#### OR Test ####");

                if(false || true) then
                        writeln("if: ortest: true");
                else
                        writeln("Nothing!");

                if(false || false) then
                        writeln("Nothing!");
                else
                        writeln("else: ortest: false");

                writeln("#### AND Test ####");

                if(false && true) then
                        writeln("Nothing!");
                else
                        writeln("else: andtest: false");

                if(true && true) then
                        writeln("if: andtest: true");
                else
                        writeln("Nothing!");

                #### Indefinite loop Test ####

                # while (1 > 0)
                #         writeln("Indefinite Loop!");                        

                writeln("#### Fake loop Test ####");

                while (0 == 1)
                        writeln("Fake Loop!");                        
                return 0;
        }
}
