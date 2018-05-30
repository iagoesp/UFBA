#ifndef CONTROL_H
#define CONTROL_H
    #include <GLFW/glfw3.h>
    #include <glm/glm.hpp>
    #include <glm/gtc/matrix_transform.hpp>


class control
{
    public:
        control();
        virtual ~control();
        void computeMatricesFromInputs(GLFWwindow* window);
        glm::mat4 getViewMatrix();
        glm::mat4 getProjectionMatrix();

    protected:

    private:
        float angle = 60.0;

        // Initial position : on +Z
        glm::vec3 position = glm::vec3( -9, 25, 56 );
        glm::vec3 rightN;
        // Initial horizontal angle : toward -Z
        float horizontalAngle = angle;
        // Initial vertical angle : none
        float verticalAngle = 0.0;
        // Initial Field of View
        float initialFoV = 45.0f;

        float speed = 9.0f; // 3 units / second
        float mouseSpeed = 0.005f;

        float RATIO = 4.0f / 3.0f;
        float farDist   = 100.0;
        float nearDist  = 0.1;

        float hFar = 1024.0;
        float wFar = 768.0;
        float hNear = 2 * tan(initialFoV / 2) * nearDist;
        float wNear = hNear * RATIO;
};

#endif // CONTROL_H
