#ifndef TRIANGLE_H
#define TRIANGLE_H

#include "point.h"

class Triangle{
public:
  // define the attributes
  Triangle(Point* a, Point* b, Point* c);
  double area();
  Point* random();
};


#endif
