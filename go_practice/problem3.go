package main

import (
	"fmt"
)


func is_even(num int) bool {
	var res bool = false
	if num % 2 == 0 {
		res = true
	}
	return res
}

func set_half(num int) int {
	var half int = 0
	if is_even(num) {
		half = num / 2
	}else{
		half = (num - 1)/2
	}
	return half
}

func is_prime(num int) bool {
	var i int = 2
	var res bool = true
	var half int = set_half(num)

	if num == 1 {
		res = false
	}else{
		for {
	 		if i > half{
	 			break
	 		}
	 		if num%i==0 {
	 			res = false
	 			break
	 		}
	 		i += 1
	 	}
	}
 	return res
}


func main() {
	var num int = 600851475143
	//var num int = 7
	var max_prime int = 1
	var i int = 2
	var half int = set_half(num)

	for {
 		if i > half {
    		break 
 		}
 		if num % i == 0{
 			num /= i
 			max_prime = i
 		}else{
 			i+=1
 		}
	}

	fmt.Println(max_prime)
}