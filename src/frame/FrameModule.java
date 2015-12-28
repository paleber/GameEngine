package frame;

import com.google.inject.AbstractModule;
import frame.Frame;
import frame.IFrame;

public final class FrameModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IFrame.class).to(Frame.class);
    }

}
