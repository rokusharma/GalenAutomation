package utilties;

import com.github.dockerjava.api.model.Device;

public enum Devices {
    IPHONE_14_PRO("iphone14pro",393,852),
    DESKTOP("desktop",1100,1440);

    private final int height;
    private final int width;
    private final String deviceName;

    Devices(String deviceName,int width,int height){
        this.deviceName=deviceName;
        this.height=height;
        this.width=width;
    }

    public Integer getHeight(){
        return this.height;
    }

    public Integer getWidth(){
        return this.width;
    }

    public String getDeviceName(){
        return this.deviceName;
    }

    public static Devices getLabelByOption(String deviceName){
        for(Devices device:Devices.values()){
            if(device.getDeviceName().equalsIgnoreCase(deviceName)){
                return device;
            }
        }
        return null;
    }

}
