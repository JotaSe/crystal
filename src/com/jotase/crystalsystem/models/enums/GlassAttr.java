/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.models.enums;

/**
 *
 * @author JotaSe
 */
public class GlassAttr {

    public enum GlassService {

        DRILLING(0, "Perforado"),
        SMALL_TACAS(1, "Tacas pequeñas"),
        BIG_TACAS(2, "Tacas grandes"),
        EDGING(3, "Canteo"),
        FULL_SERVICE(4, "Templado y canteo incluido");
        final int id;
        final String name;

        private GlassService(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public static GlassService getState(int id) {
            for (GlassService action : GlassService.values()) {
                if (action.id == id) {
                    return action;
                }
            }
            return null;
        }

        public static GlassService getState(String name) {
            for (GlassService action : GlassService.values()) {
                if (action.name.equals(name)) {
                    return action;
                }
            }
            return null;
        }

    }

    public enum GlassThickness {

        MM5(0, 5, "5 mm"),
        MM6(1, 6, "6 mm"),
        MM8(2, 8, "8 mm"),
        MM10(3, 10, "10 mm"),
        MM12(4, 12, "12 mm"),
        MM16(5, 16, "16 mm"),
        MM19(6, 19, "19 mm");
        final int id;
        final String name;
        final int thickness;

        private GlassThickness(int id, int thickness, String name) {
            this.id = id;
            this.name = name;
            this.thickness = thickness;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public static GlassThickness getState(int id) {
            for (GlassThickness action : GlassThickness.values()) {
                if (action.id == id) {
                    return action;
                }
            }
            return null;
        }

        public static GlassThickness getState(String name) {
            for (GlassThickness action : GlassThickness.values()) {
                if (action.name.equals(name)) {
                    return action;
                }
            }
            return null;
        }

    }

    public enum GlassState {

        PRODUCTION(0, "Produccion"),
        CUT(1, "Corte"),
        EDGING(2, "Canteo"),
        DRILLING(3, "Perforacion y Tacas"),
        TEMPERED(4, "Templado"),
        DELIVERED(5, "Entregado");
        final int id;
        final String name;

        private GlassState(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public static GlassState getState(int id) {
            for (GlassState action : GlassState.values()) {
                if (action.id == id) {
                    return action;
                }
            }
            return null;
        }

        public static GlassState getState(String name) {
            for (GlassState action : GlassState.values()) {
                if (action.name.equals(name)) {
                    return action;
                }
            }
            return null;
        }
    }

    public enum PriceType {

        PRICE_A(0, "Precio A"),
        PRICE_B(1, "Precio B"),
        PRICE_C(2, "Precio C");
        final int id;
        final String name;

        private PriceType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public static PriceType getState(int id) {
            for (PriceType action : PriceType.values()) {
                if (action.id == id) {
                    return action;
                }
            }
            return null;
        }

        public static PriceType getState(String name) {
            for (PriceType action : PriceType.values()) {
                if (action.name.equals(name)) {
                    return action;
                }
            }
            return null;
        }

    }
}
