#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>

#ifndef PLANE_H
#define PLANE_H

class Plane{
    private:
        float A;
        float B;
        float C;
        float D;
        glm::vec3 p;
        glm::vec3 n;
        glm::vec2 pN;
    public:
        Plane(glm::vec3 p0, glm::vec3 p1, glm::vec3 p2);
        virtual ~Plane();
        bool estaNoPlano(glm::vec3 pS);
        float distancia(glm::vec3 pS);
        float getA();
        float getB();
        float getC();
        float getD();
        glm::vec2 getPN();
        glm::vec3 getP();
        glm::vec3 getN();
};
#endif // PLANE_H
