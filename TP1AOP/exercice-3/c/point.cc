#include "point.h"
#include <iostream>

Point::Point(const double x, const double y): x(x),y(y){}

Point* Point::vector(Point* p){
  // replace with your code
  return NULL;
}

Point* Point::center(Point* b) {
  // replace with your code
  return NULL;
}


Point* Point::translate(Point* p){
  // replace with your code
  return NULL;
}

Point* Point::scal(double coef){
  // replace with your code
  return NULL;
}

double Point::det(Point* p){
  // replace the return -1 with your code
  return -1;
}

// dont modify me, i'm used for the tests!
std::string Point::to_string (){
  return std::to_string(x) + " " + std::to_string(y);
}
