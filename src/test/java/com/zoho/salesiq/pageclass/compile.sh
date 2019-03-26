CLASS_PATH=
for i in `ls ../lib/*.jar`	
do
	CLASS_PATH=$i:$CLASS_PATH;
done
export CLASSPATH=$CLASS_PATH:$CLASSPATH
javac -d . *.java

echo ---------------------Compiled------------------------------
