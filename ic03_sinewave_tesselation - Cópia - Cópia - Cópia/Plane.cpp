#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include "Plane.h"

Plane::Plane(glm::vec3 p0, glm::vec3 p1, glm::vec3 p2){
            glm::vec3 v = p1 - p0;
            glm::vec3 u = p2 - p0;
            glm::vec3 n = cross(v, u);
            n = normalize(n);
            this->A = n.x;
            this->B = n.y;
            this->C = n.z;
            this->n = n;
            this->p = p0;
            this->D = dot(-n, p0);
            this->pN = (this->p, this->n);
}

bool Plane::estaNoPlano(glm::vec3 pS){
    glm::vec3 v1 = pS-this->p;
    if(dot(v1, n) == 0)
        return true;
    else
        return false;
}

float Plane::getA(){
    return this->A;
}

float Plane::getB(){
    return this->B;
}

float Plane::getC(){
    return this->C;
}

float Plane::getD(){
    return this->D;
}

glm::vec3 Plane::getP(){
    return this->p;
}

glm::vec3 Plane::getN(){
    return this->n;
}

glm::vec2 Plane::getPN(){
    return this->pN;
}
