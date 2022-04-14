/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.utils;

import cn.limitless.cathatmusic.enums.FileType;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/5
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public class FileTypeTransformer {

    public static FileType getFileTypeFromExt(String ext) {
        if (isAudio(ext)) {
            return FileType.AUDIO;
        }

        if (isImage(ext)) {
            return FileType.IMAGE;
        }

        if (isVideo(ext)) {
            return FileType.VIDEO;
        }

        return FileType.OTHER;
    }

    private static Boolean isVideo(String ext) {
        String[] videoExt = {"vob", "mp4", "avi",
                "flv", "f4v", "wmv", "mov", "rmvb",
                "mkv", "mpg", "m4v", "webm", "rm",
                "mpeg", "asf", "ts", "mts"};
        for (String perExt : videoExt) {
            if (perExt.equals(ext)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static Boolean isAudio(String ext) {
        String[] videoExt = {"mp3", "wav"};
        for (String perExt : videoExt) {
            if (perExt.equals(ext)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    private static Boolean isImage(String ext) {
        String[] videoExt = {"png", "jpg", "jpeg"};
        for (String perExt : videoExt) {
            if (perExt.equals(ext)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


}
