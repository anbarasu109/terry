adb -s emulator-5556 shell screencap -p /sdcard/screen.png

adb pull /sdcard/screen.png

val = `expr $3 - $1`

val1 = `expr $4 - $2`
convert screen.png -crop valxval1+$2+$3 $1.jpg