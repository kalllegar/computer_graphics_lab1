package com.example.computer_graphics_lab1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public TextField rValue;
    @FXML
    public Slider rSliderValue;
    @FXML
    public TextField gValue;
    @FXML
    public Slider gSliderValue;
    @FXML
    public TextField bValue;
    @FXML
    public Slider bSliderValue;
    @FXML
    public Canvas canvas;
    @FXML
    public TextField cValue;
    @FXML
    public Slider cSliderValue;
    @FXML
    public TextField mValue;
    @FXML
    public Slider mSliderValue;
    @FXML
    public TextField yValue;
    @FXML
    public Slider ySliderValue;
    @FXML
    public TextField kValue;
    @FXML
    public Slider kSliderValue;
    @FXML
    public TextField hValue;
    @FXML
    public Slider hSliderValue;
    @FXML
    public TextField sValue;
    @FXML
    public Slider sSliderValue;
    @FXML
    public TextField lValue;
    @FXML
    public Slider lSliderValue;

    private boolean rgbFlag = true;
    private boolean cmykFlag = true;

    private boolean hslFlag = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colorPicker.setValue(Color.BLACK);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 100, 200);
        //red
        rSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (rgbFlag) {
                    rValue.setText(String.valueOf(newValue.intValue()));
                    cmykFlag = false;
                    hslFlag = false;
                    RGBtoCMYK();
                    RGBtoHSL();
                    RewriteColor();
                    hslFlag = true;
                    cmykFlag = true;
                }
            }
        });
        //green
        gSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (rgbFlag) {
                    gValue.setText(String.valueOf(newValue.intValue()));
                    hslFlag = false;
                    cmykFlag = false;
                    RGBtoCMYK();
                    RGBtoHSL();
                    RewriteColor();
                    cmykFlag = true;
                    hslFlag = true;
                }
            }
        });
        //blue
        bSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (rgbFlag) {
                    bValue.setText(String.valueOf(newValue.intValue()));
                    hslFlag = false;
                    cmykFlag = false;
                    RGBtoCMYK();
                    RGBtoHSL();
                    RewriteColor();
                    cmykFlag = true;
                    hslFlag = true;
                }
            }
        });
        //cyan
        cSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (cmykFlag) {
                    cValue.setText(String.valueOf(newValue.intValue()));
                    rgbFlag = false;
                    CMYKtoRGB();
                    RGBtoHSL();
                    RewriteColor();
                    rgbFlag = true;
                }
            }
        });
        //magenta
        mSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (cmykFlag) {
                    mValue.setText(String.valueOf(newValue.intValue()));
                    hslFlag = false;
                    rgbFlag = false;
                    CMYKtoRGB();
                    RGBtoHSL();
                    RewriteColor();
                    rgbFlag = true;
                    hslFlag = true;
                }
            }
        });
        //yellow
        ySliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (cmykFlag) {
                    yValue.setText(String.valueOf(newValue.intValue()));
                    rgbFlag = false;
                    hslFlag = false;
                    CMYKtoRGB();
                    RGBtoHSL();
                    RewriteColor();
                    hslFlag = true;
                    rgbFlag = true;
                }
            }
        });
        //black
        kSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (cmykFlag) {
                    kValue.setText(String.valueOf(newValue.intValue()));
                    rgbFlag = false;
                    hslFlag = false;
                    CMYKtoRGB();
                    RGBtoHSL();
                    RewriteColor();
                    rgbFlag = true;
                    hslFlag = true;
                }
            }
        });
        ///hue
        hSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (hslFlag) {
                    hValue.setText(String.valueOf(newValue.intValue()));
                    rgbFlag = false;
                    cmykFlag = false;
                    HSLtoRGB();
                    RGBtoCMYK();
                    RewriteColor();
                    rgbFlag = true;
                    cmykFlag = true;
                }
            }
        });
        ///saturation
        sSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (hslFlag) {
                    sValue.setText(String.valueOf(newValue.intValue()));
                    rgbFlag = false;
                    cmykFlag = false;
                    HSLtoRGB();
                    RGBtoCMYK();
                    RewriteColor();
                    rgbFlag = true;
                    cmykFlag = true;
                }
            }
        });
        ///lightness
        lSliderValue.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                if (hslFlag) {
                    lValue.setText(String.valueOf(newValue.intValue()));
                    rgbFlag = false;
                    cmykFlag = false;
                    HSLtoRGB();
                    RGBtoCMYK();
                    RewriteColor();
                    rgbFlag = true;
                    cmykFlag = true;
                }
            }
        });
    }

    @FXML
    public void OnColorPickerChange() {
        rValue.setText(String.valueOf(Math.round(colorPicker.getValue().getRed() * 255)));
        gValue.setText(String.valueOf(Math.round(colorPicker.getValue().getGreen() * 255)));
        bValue.setText(String.valueOf(Math.round(colorPicker.getValue().getBlue() * 255)));
        rSliderValue.setValue(Math.floor(colorPicker.getValue().getRed() * 255));
        gSliderValue.setValue(Math.floor(colorPicker.getValue().getGreen() * 255));
        bSliderValue.setValue(Math.floor(colorPicker.getValue().getBlue() * 255));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(colorPicker.getValue());
        gc.fillRect(0, 0, 100, 200);
    }

    @FXML
    public void RewriteColor() {
        Color newColor = Color.rgb(Integer.parseInt(rValue.getText()), Integer.parseInt(gValue.getText()), Integer.parseInt(bValue.getText()));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(newColor);
        gc.fillRect(0, 0, 100, 200);
        colorPicker.setValue(newColor);
    }

    @FXML
    public void RewriteColorRGB() {
        rSliderValue.setValue(Integer.parseInt(rValue.getText()));
        gSliderValue.setValue(Integer.parseInt(gValue.getText()));
        bSliderValue.setValue(Integer.parseInt(bValue.getText()));
    }

    @FXML
    public void RewriteColorCMYK() {
        cSliderValue.setValue(Integer.parseInt(cValue.getText()));
        mSliderValue.setValue(Integer.parseInt(mValue.getText()));
        ySliderValue.setValue(Integer.parseInt(yValue.getText()));
        kSliderValue.setValue(Integer.parseInt(kValue.getText()));
    }

    @FXML
    public void RewriteColorHSL() {
        hSliderValue.setValue(Integer.parseInt(hValue.getText()));
        sSliderValue.setValue(Integer.parseInt(sValue.getText()));
        lSliderValue.setValue(Integer.parseInt(lValue.getText()));
    }

    private void RGBtoCMYK() {
        double k = Math.min(Math.min(1 - Integer.parseInt(rValue.getText()) / 255., 1 - Integer.parseInt(gValue.getText()) / 255.), 1 - Integer.parseInt(bValue.getText()) / 255.);
        long c = Math.round((1 - Integer.parseInt(rValue.getText()) / 255. - k) / (1 - k) * 100);
        long m = Math.round((1 - Integer.parseInt(gValue.getText()) / 255. - k) / (1 - k) * 100);
        long y = Math.round((1 - Integer.parseInt(bValue.getText()) / 255. - k) / (1 - k) * 100);
        k *= 100;
        kValue.setText(String.valueOf(Math.round(k)));
        cValue.setText(String.valueOf(c));
        mValue.setText(String.valueOf(m));
        yValue.setText(String.valueOf(y));
        cSliderValue.setValue(Integer.parseInt(cValue.getText()));
        mSliderValue.setValue(Integer.parseInt(mValue.getText()));
        ySliderValue.setValue(Integer.parseInt(yValue.getText()));
        kSliderValue.setValue(Integer.parseInt(kValue.getText()));
    }

    private void CMYKtoRGB() {
        rValue.setText(String.valueOf(Math.round(255 * (1 - Integer.parseInt(cValue.getText()) / 100.) * (1 - Integer.parseInt(kValue.getText()) / 100.))));
        gValue.setText(String.valueOf(Math.round(255 * (1 - Integer.parseInt(mValue.getText()) / 100.) * (1 - Integer.parseInt(kValue.getText()) / 100.))));
        bValue.setText(String.valueOf(Math.round(255 * (1 - Integer.parseInt(yValue.getText()) / 100.) * (1 - Integer.parseInt(kValue.getText()) / 100.))));
        rSliderValue.setValue(Integer.parseInt(rValue.getText()));
        gSliderValue.setValue(Integer.parseInt(gValue.getText()));
        bSliderValue.setValue(Integer.parseInt(bValue.getText()));
    }

    private void RGBtoHSL() {
        double r = Integer.parseInt(rValue.getText()) / 255.;
        double g = Integer.parseInt(gValue.getText()) / 255.;
        double b = Integer.parseInt(bValue.getText()) / 255.;
        double h, s, l;
        if (r >= b && r >= g) {
            if (b <= g) {
                /// cmax = r, cmin = b
                double delta = r - b;
                l = (r + b) / 2;
                if (delta < 0.000001) {
                    h = 0;
                    s = 0;
                } else {
                    h = 60 * (((g - b) / delta) % 6);
                    s = delta / (1 - Math.abs(2 * l - 1));
                }
            } else {
                ///cmax = r, cmin = g
                double delta = r - g;
                l = (r + g) / 2;
                if (delta < 0.000001) {
                    h = 0;
                    s = 0;
                } else {
                    h = 60 * (((g - b) / delta) % 6);
                    s = delta / (1 - Math.abs(2 * l - 1));
                }
            }
        } else if (g >= r && g >= b) {
            if (r <= b) {
                ///cmax = g, cmin = r
                double delta = g - r;
                l = (g + r) / 2;
                if (delta < 0.000001) {
                    h = 0;
                    s = 0;
                } else {
                    h = 60 * (((b - r) / delta) + 2);
                    s = delta / (1 - Math.abs(2 * l - 1));
                }
            } else {
                ///cmax = g, cmin = b
                double delta = g - b;
                l = (g + b) / 2;
                if (delta < 0.000001) {
                    h = 0;
                    s = 0;
                } else {
                    h = 60 * (((b - r) / delta) + 2);
                    s = delta / (1 - Math.abs(2 * l - 1));
                }
            }
        } else {
            if (r <= g) {
                ///cmax = b, cmin = r
                double delta = b - r;
                l = (b + r) / 2;
                if (delta < 0.000001) {
                    h = 0;
                    s = 0;
                } else {
                    h = 60 * (((r - g) / delta) + 4);
                    s = delta / (1 - Math.abs(2 * l - 1));
                }
            } else {
                ///cmax = b, cmin = g
                double delta = b - g;
                l = (b + g) / 2;
                if (delta < 0.000001) {
                    h = 0;
                    s = 0;
                } else {
                    h = 60 * (((r - g) / delta) + 2);
                    s = delta / (1 - Math.abs(2 * l - 1));
                }
            }
        }
        if (h < 0) {
            h += 360;
        }
        hValue.setText(String.valueOf(Math.round(h)));
        sValue.setText(String.valueOf(Math.round(s * 100)));
        lValue.setText(String.valueOf(Math.round(l * 100)));
        hSliderValue.setValue(Math.round(h));
        sSliderValue.setValue(Math.round(s * 100));
        lSliderValue.setValue(Math.round(l * 100));
    }

    private void HSLtoRGB() {
        double h = Integer.parseInt(hValue.getText());
        double s = Integer.parseInt(sValue.getText()) / 100.;
        double l = Integer.parseInt(lValue.getText()) / 100.;
        double c = (1 - Math.abs(2 * l - 1)) * s;
        double x = c * (1 - Math.abs((h / 60) % 2 - 1));
        double m = l - c/2;
        double r, g ,b;
        if(h <= 60){
            r = c;
            g = x;
            b = 0;
        } else if(h <= 120){
            r = x;
            g = c;
            b = 0;
        } else if(h <= 180){
            r = 0;
            g = c;
            b = x;
        } else if(h <= 240){
            r = 0;
            g = x;
            b = c;
        } else if(h <= 320){
            r = x;
            g = 0;
            b = c;
        } else {
            r = c;
            g = 0;
            b = x;
        }
        rValue.setText(String.valueOf(Math.round(((r + m)*255))));
        gValue.setText(String.valueOf(Math.round(((g + m)*255))));
        bValue.setText(String.valueOf(Math.round(((b + m)*255))));
    }
}