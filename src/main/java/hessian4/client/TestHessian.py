#!/usr/bin/env python
#coding=utf-8
# -*- coding:utf-8 -*-
########################################
#--2009-12-16--
#@author migle longforfreedom@gmail.com
########################################
###
### Hessian 测试
###
########################################

import hessianlib

if __name__ == '__main__':
	proxy = hessianlib.Hessian('http://localhost/HessianServer/hessian')
	try:
		print proxy.sayHello('migle')
		proxy.printHello('Python')
	except Error, v:
		print 'ERROR',