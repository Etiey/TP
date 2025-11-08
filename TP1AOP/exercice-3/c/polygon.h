#ifndef POLYGON_H
#define POLYGON_H

#include <vector>
#include "point.h"
#include "triangle.h"

class Polygon{
public:
  // define the attributes

  Polygon(std::vector<Point*> vert);
  double area();
  Point* random();
};
#endif
