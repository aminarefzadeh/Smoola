.class public Tool
.super java/lang/Object
.method public <init>()V
.limit locals 1
.limit stack 32
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public print([I)I
.limit locals 3
.limit stack 32
bipush 0
dup
istore_2
pop
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "["
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
nStart0:
iload_2
aload_1
arraylength
if_icmplt nElse1
iconst_0
goto nExit1
nElse1:
iconst_1
nExit1:
ifeq nExit0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_1
iload_2
iaload
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc ","
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
iload_2
bipush 1
iadd
dup
istore_2
pop
goto nStart0
nExit0:
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "]\n"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
bipush 0
ireturn
.end method