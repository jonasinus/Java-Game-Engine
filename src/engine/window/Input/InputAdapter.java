package engine.window.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

/**
 * This class is used to create a class that implements all needed methods from java.awt.event.*Listener. <p>
 * 
 * @author NextLegacy
 * @version 1.0
 */
public abstract class InputAdapter implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener, WindowListener, WindowFocusListener, WindowStateListener
{
    // KeyListener
    @Override public void keyPressed (KeyEvent e) { }
    @Override public void keyReleased(KeyEvent e) { }
    @Override public void keyTyped   (KeyEvent e) { }

    // MouseListener
    @Override public void mouseClicked   (MouseEvent e) { }
    @Override public void mouseEntered   (MouseEvent e) { }
    @Override public void mouseExited    (MouseEvent e) { }
    @Override public void mousePressed   (MouseEvent e) { }
    @Override public void mouseReleased  (MouseEvent e) { }
    
    // MouseMotionListener
    @Override public void mouseMoved     (MouseEvent e) { }
    @Override public void mouseDragged   (MouseEvent e) { }

    // MouseWheelListener
    @Override public void mouseWheelMoved(MouseWheelEvent e) { }

    // WindowListener
    @Override public void windowClosing     (WindowEvent e) { }
    @Override public void windowOpened      (WindowEvent e) { }
    @Override public void windowActivated   (WindowEvent e) { }
    @Override public void windowClosed      (WindowEvent e) { }
    @Override public void windowDeactivated (WindowEvent e) { }
    @Override public void windowDeiconified (WindowEvent e) { }
    @Override public void windowIconified   (WindowEvent e) { }

    // WindowFocusListener
    @Override public void windowGainedFocus (WindowEvent e) { }
    @Override public void windowLostFocus   (WindowEvent e) { }

    // WindowStateListener
    @Override public void windowStateChanged(WindowEvent e) { }
}