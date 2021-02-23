#安卓手电筒应用

# 核心代码
##开启闪光灯
		camera = Camera.open();<br>
		Parameters parameters = camera.getParameters();<br>
		parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);<br>
		camera.setParameters(parameters);<br>
		camera.startPreview();<br>
##关闭闪光灯
		camera.stopPreview();<br>
		camera.release();<br>

