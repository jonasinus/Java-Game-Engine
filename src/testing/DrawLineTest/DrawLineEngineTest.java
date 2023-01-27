package testing.DrawLineTest;

import engine.GameObject;
import engine.Scene;
import engine.Script;
import engine.graphics.Image;
import engine.graphics.ImageAlgorithms3D;
import engine.math.FinalVector;
import engine.math.Matrix;
import engine.math.Quaternion;
import engine.math.Vector;
import engine.threed.Triangle;
import engine.threed.Vertex;
import engine.utils.Screen;
import engine.utils.ThreedUtils;

import static engine.utils.MathUtils.*;

import engine.Engine;

public class DrawLineEngineTest 
{
    public static void main(String[] args)
    {
        Engine engine = new Engine(Screen.get(0), vec(1080, 720), 60, 60, "main");

        engine.setActiveScene(new LineTestScene());

        engine.activate();
    }    

    public static class LineTestScene extends Scene
    {
        @Override
        protected void init() 
        {
            GameObject gameObject = new GameObject();
            addGameObject(gameObject);
            
            gameObject.addScript(new LineTestScript());

            gameObject.scripts()[0].activate();
            gameObject.activate();
        }
    }

    public static class LineTestScript extends Script
    {
        @Override protected void start() { setActive(true); a = b = c = fvec(0, 0); }

        private FinalVector a;
        private FinalVector b;
        private FinalVector c;

        private FinalVector cameraTarget = fvec(0, 0, 1);

        @Override
        protected void update() 
        {
            if (left().isDown())
                a = mouse().position();
            if (right().isDown())
                b = mouse().position();  
            if (wheel().isDown())
                c = mouse().position();

            t += 112 * deltaTime();

            z += wheel().direction();
        }

        double t = 0;

        double z = 0;

        @Override
        protected void render() 
        {
            ImageAlgorithms3D.line(
                image(), 
                new Vertex(a.plus(0, 0, 5), new Vector(0.25, 0.25, 1), a), 
                new Vertex(b.plus(0, 0, 20), new Vector(0.25, 1   , 1), b), 
                Image.fromFile("./rsc/images/A.png")
            );

            image().fillTriangle(
                new Triangle
                (
                    new Vertex(a.plus(0, 0, 5), new Vector(0.25, 0.25, 1), a), 
                    new Vertex(b.plus(0, 0, -20), new Vector(0.25, 1   , 1), b), 
                    new Vertex(c.plus(0, 0, 20), new Vector(0.75, 0.25, 1), c)
                ), 
                Image.fromFile("./rsc/images/A.png")
            );
            ImageAlgorithms3D.mesh(
                image(), 
                ThreedUtils.MeshFromObjFile("./rsc/meshes/monkey.obj"),
                Matrix.MakeTransformation(vec(0, 0, z), vec(3, 3, 3), Quaternion.FromEuler(vec(-t, t, -t).times(0.1))),
                Matrix.makeProjection(90, 720d/1080d, 0.1, 1000),
                Matrix.MakeView(vec(0, 0, 0), cameraTarget, vec(0, 1, 0)),
                vec(0, 0, 0),
                Image.fromFile("./rsc/out.png")
            );

            ImageAlgorithms3D.mesh(
                image(), 
                ThreedUtils.MeshFromObjFile("./rsc/meshes/cube.obj"),
                Matrix.MakeTransformation(vec(0, 0, 20), vec(3, 3, 3), Quaternion.FromEuler(vec(t, t, t).times(0.1))),
                Matrix.makeProjection(90, 720d/1080d, 0.1, 1000),
                Matrix.MakeView(vec(0, 0, 0), cameraTarget, vec(0, 1, 0)),
                vec(0, 0, 0),
                Image.fromFile("./rsc/images/A.png")
            );
        }
    }
}
