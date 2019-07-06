package main

import (
	"fmt"
)

func main() {
	var even_sum int = 0
	var max int = 4000000

	var prev int =1
	var now int =2
	var temp int = now

	even_sum += now

	for {
		temp = now
 		now += prev
 		prev = temp
 		if now > max {
    		break
 		}else{
 			if now %2 == 0{
 				even_sum += now	
 			}
 		}
	}
	fmt.Println(even_sum)
}