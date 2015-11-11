package frame_old;

import com.google.inject.AbstractModule;

public final class FrameModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IFrame.class).to(Frame.class);
    }

}
