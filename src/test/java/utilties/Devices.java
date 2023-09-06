package utilties;

import com.github.dockerjava.api.model.Device;

public enum Devices {
    MOBILE("Mobile",375,800),
    DESKTOP("Desktop",1100,1440);

    private final int height;
    private final int width;
    private final String deviceName;

    Devices(String deviceName,int height,int width){
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

    public Devices getLabelByOption(String deviceName){
        for(Devices device:Devices.values()){
            if(device.getDeviceName().equalsIgnoreCase(deviceName)){
                return device;
            }
        }
        return null;
    }

}
