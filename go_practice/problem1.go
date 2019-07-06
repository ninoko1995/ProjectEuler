package main

import (
	"fmt"
)

func main() {
	var sum int = 0
	var max int = 1000
	var x1 int = 3
	var x2 int = 5


	var multiple int =0
	var i int =0
	var x = x1

	for {
 		multiple = i*x
 		if multiple >= max {
    		break
 		}else{
 			sum += multiple
 			i+=1		
 		}
	}

	i =0
	x = x2

	for {
 		multiple = i*x
 		if multiple >= max {
    		break
 		}else{
 			if multiple % x1 != 0{
 				sum += multiple
 			}
 			i+=1
 		}
	}

	

	fmt.Println(sum)
}