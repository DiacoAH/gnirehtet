package com.genymobile.gnirehtet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Net {
    private Net() {
        // not instantiable
    }

    public static InetAddress[] toInetAddresses(String... addresses) {
        InetAddress[] result = new InetAddress[addresses.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = toInetAddress(addresses[i]);
        }
        return result;
    }

    public static InetAddress toInetAddress(String address) {
        try {
            return InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static InetAddress toInetAddress(byte[] raw) {
        try {
            return InetAddress.getByAddress(raw);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e);
        }
    }
}