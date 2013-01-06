package com.prettybit.bundles.entity;

/**
 * @author Pavel Mikhalchuk
 */
public class UserAgent {

    private OS os;

    public UserAgent(String header) {
        this.os = parseOs(header.toLowerCase());
    }

    public OS getOs() {
        return os;
    }

    private OS parseOs(String header) {
        if (header.contains("mac os")) return new MacOS();
        if (header.contains("linux")) return new Linux();
        if (header.contains("windows")) return new Windows();
        throw new IllegalArgumentException("Cannot parse OS from header.");
    }

}