PGDMP         ;                x            pizza    12.1    12.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16904    pizza    DATABASE     �   CREATE DATABASE pizza WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE pizza;
                postgres    false            �            1259    16907    pizzas    TABLE     k   CREATE TABLE public.pizzas (
    id integer NOT NULL,
    name character varying(30),
    price integer
);
    DROP TABLE public.pizzas;
       public         heap    postgres    false            �            1259    16905    pizzas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pizzas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pizzas_id_seq;
       public          postgres    false    203                       0    0    pizzas_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.pizzas_id_seq OWNED BY public.pizzas.id;
          public          postgres    false    202            
           2604    16910 	   pizzas id    DEFAULT     f   ALTER TABLE ONLY public.pizzas ALTER COLUMN id SET DEFAULT nextval('public.pizzas_id_seq'::regclass);
 8   ALTER TABLE public.pizzas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203                      0    16907    pizzas 
   TABLE DATA           1   COPY public.pizzas (id, name, price) FROM stdin;
    public          postgres    false    203   >
       	           0    0    pizzas_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.pizzas_id_seq', 2, true);
          public          postgres    false    202            �
           2606    16912    pizzas pizzas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.pizzas
    ADD CONSTRAINT pizzas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pizzas DROP CONSTRAINT pizzas_pkey;
       public            postgres    false    203                  x�3��H����420������ $�|     