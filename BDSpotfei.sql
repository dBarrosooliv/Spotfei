PGDMP                      }            ProjetoSpotfeiDB    17.4    17.4 D               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false                       1262    16398    ProjetoSpotfeiDB    DATABASE     x   CREATE DATABASE "ProjetoSpotfeiDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'pt-BR';
 "   DROP DATABASE "ProjetoSpotfeiDB";
                     postgres    false            �            1259    16431    artistas_cadastrados    TABLE     v   CREATE TABLE public.artistas_cadastrados (
    artistaid integer NOT NULL,
    nome_artista character varying(255)
);
 (   DROP TABLE public.artistas_cadastrados;
       public         heap r       postgres    false            �            1259    16430 "   artistas_cadastrados_artistaid_seq    SEQUENCE     �   CREATE SEQUENCE public.artistas_cadastrados_artistaid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.artistas_cadastrados_artistaid_seq;
       public               postgres    false    220                       0    0 "   artistas_cadastrados_artistaid_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.artistas_cadastrados_artistaid_seq OWNED BY public.artistas_cadastrados.artistaid;
          public               postgres    false    219            �            1259    16511    historico_descurtida    TABLE     {   CREATE TABLE public.historico_descurtida (
    id_descurtida integer NOT NULL,
    userid integer,
    musicaid integer
);
 (   DROP TABLE public.historico_descurtida;
       public         heap r       postgres    false            �            1259    16510 &   historico_descurtida_id_descurtida_seq    SEQUENCE     �   CREATE SEQUENCE public.historico_descurtida_id_descurtida_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.historico_descurtida_id_descurtida_seq;
       public               postgres    false    229                       0    0 &   historico_descurtida_id_descurtida_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.historico_descurtida_id_descurtida_seq OWNED BY public.historico_descurtida.id_descurtida;
          public               postgres    false    228            �            1259    16528    historico_pesquisa_usuario    TABLE     �   CREATE TABLE public.historico_pesquisa_usuario (
    id_pesquisa integer NOT NULL,
    userid integer,
    termo_pesquisa character varying(255)
);
 .   DROP TABLE public.historico_pesquisa_usuario;
       public         heap r       postgres    false            �            1259    16527 *   historico_pesquisa_usuario_id_pesquisa_seq    SEQUENCE     �   CREATE SEQUENCE public.historico_pesquisa_usuario_id_pesquisa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 A   DROP SEQUENCE public.historico_pesquisa_usuario_id_pesquisa_seq;
       public               postgres    false    231                       0    0 *   historico_pesquisa_usuario_id_pesquisa_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public.historico_pesquisa_usuario_id_pesquisa_seq OWNED BY public.historico_pesquisa_usuario.id_pesquisa;
          public               postgres    false    230            �            1259    16440    musicas_cadastradas    TABLE     �   CREATE TABLE public.musicas_cadastradas (
    musicaid integer NOT NULL,
    titulo_musica character varying(255),
    album character varying(255),
    artistaid integer
);
 '   DROP TABLE public.musicas_cadastradas;
       public         heap r       postgres    false            �            1259    16439     musicas_cadastradas_musicaid_seq    SEQUENCE     �   CREATE SEQUENCE public.musicas_cadastradas_musicaid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.musicas_cadastradas_musicaid_seq;
       public               postgres    false    222                       0    0     musicas_cadastradas_musicaid_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.musicas_cadastradas_musicaid_seq OWNED BY public.musicas_cadastradas.musicaid;
          public               postgres    false    221            �            1259    16454    playlist    TABLE     �   CREATE TABLE public.playlist (
    playlistid integer NOT NULL,
    titulo_playlist character varying(255),
    userid integer
);
    DROP TABLE public.playlist;
       public         heap r       postgres    false            �            1259    16453    playlist_playlistid_seq    SEQUENCE     �   CREATE SEQUENCE public.playlist_playlistid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.playlist_playlistid_seq;
       public               postgres    false    224                       0    0    playlist_playlistid_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.playlist_playlistid_seq OWNED BY public.playlist.playlistid;
          public               postgres    false    223            �            1259    16465    relacao_playlist_musica    TABLE     p   CREATE TABLE public.relacao_playlist_musica (
    playlistid integer NOT NULL,
    musicaid integer NOT NULL
);
 +   DROP TABLE public.relacao_playlist_musica;
       public         heap r       postgres    false            �            1259    16480    relacao_user_curtida    TABLE     i   CREATE TABLE public.relacao_user_curtida (
    userid integer NOT NULL,
    musicaid integer NOT NULL
);
 (   DROP TABLE public.relacao_user_curtida;
       public         heap r       postgres    false            �            1259    16495    relacao_user_descurtida    TABLE     l   CREATE TABLE public.relacao_user_descurtida (
    userid integer NOT NULL,
    musicaid integer NOT NULL
);
 +   DROP TABLE public.relacao_user_descurtida;
       public         heap r       postgres    false            �            1259    16420    usuarios_cadastrados    TABLE     �   CREATE TABLE public.usuarios_cadastrados (
    userid integer NOT NULL,
    nome text NOT NULL,
    username text NOT NULL,
    senha text NOT NULL
);
 (   DROP TABLE public.usuarios_cadastrados;
       public         heap r       postgres    false            �            1259    16419    usuarios_cadastrados_userid_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_cadastrados_userid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.usuarios_cadastrados_userid_seq;
       public               postgres    false    218                       0    0    usuarios_cadastrados_userid_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.usuarios_cadastrados_userid_seq OWNED BY public.usuarios_cadastrados.userid;
          public               postgres    false    217            G           2604    16434    artistas_cadastrados artistaid    DEFAULT     �   ALTER TABLE ONLY public.artistas_cadastrados ALTER COLUMN artistaid SET DEFAULT nextval('public.artistas_cadastrados_artistaid_seq'::regclass);
 M   ALTER TABLE public.artistas_cadastrados ALTER COLUMN artistaid DROP DEFAULT;
       public               postgres    false    220    219    220            J           2604    16514 "   historico_descurtida id_descurtida    DEFAULT     �   ALTER TABLE ONLY public.historico_descurtida ALTER COLUMN id_descurtida SET DEFAULT nextval('public.historico_descurtida_id_descurtida_seq'::regclass);
 Q   ALTER TABLE public.historico_descurtida ALTER COLUMN id_descurtida DROP DEFAULT;
       public               postgres    false    229    228    229            K           2604    16531 &   historico_pesquisa_usuario id_pesquisa    DEFAULT     �   ALTER TABLE ONLY public.historico_pesquisa_usuario ALTER COLUMN id_pesquisa SET DEFAULT nextval('public.historico_pesquisa_usuario_id_pesquisa_seq'::regclass);
 U   ALTER TABLE public.historico_pesquisa_usuario ALTER COLUMN id_pesquisa DROP DEFAULT;
       public               postgres    false    231    230    231            H           2604    16443    musicas_cadastradas musicaid    DEFAULT     �   ALTER TABLE ONLY public.musicas_cadastradas ALTER COLUMN musicaid SET DEFAULT nextval('public.musicas_cadastradas_musicaid_seq'::regclass);
 K   ALTER TABLE public.musicas_cadastradas ALTER COLUMN musicaid DROP DEFAULT;
       public               postgres    false    221    222    222            I           2604    16457    playlist playlistid    DEFAULT     z   ALTER TABLE ONLY public.playlist ALTER COLUMN playlistid SET DEFAULT nextval('public.playlist_playlistid_seq'::regclass);
 B   ALTER TABLE public.playlist ALTER COLUMN playlistid DROP DEFAULT;
       public               postgres    false    223    224    224            F           2604    16423    usuarios_cadastrados userid    DEFAULT     �   ALTER TABLE ONLY public.usuarios_cadastrados ALTER COLUMN userid SET DEFAULT nextval('public.usuarios_cadastrados_userid_seq'::regclass);
 J   ALTER TABLE public.usuarios_cadastrados ALTER COLUMN userid DROP DEFAULT;
       public               postgres    false    217    218    218                      0    16431    artistas_cadastrados 
   TABLE DATA           G   COPY public.artistas_cadastrados (artistaid, nome_artista) FROM stdin;
    public               postgres    false    220   J[       
          0    16511    historico_descurtida 
   TABLE DATA           O   COPY public.historico_descurtida (id_descurtida, userid, musicaid) FROM stdin;
    public               postgres    false    229   �[                 0    16528    historico_pesquisa_usuario 
   TABLE DATA           Y   COPY public.historico_pesquisa_usuario (id_pesquisa, userid, termo_pesquisa) FROM stdin;
    public               postgres    false    231   %\                 0    16440    musicas_cadastradas 
   TABLE DATA           X   COPY public.musicas_cadastradas (musicaid, titulo_musica, album, artistaid) FROM stdin;
    public               postgres    false    222   e]                 0    16454    playlist 
   TABLE DATA           G   COPY public.playlist (playlistid, titulo_playlist, userid) FROM stdin;
    public               postgres    false    224   �^                 0    16465    relacao_playlist_musica 
   TABLE DATA           G   COPY public.relacao_playlist_musica (playlistid, musicaid) FROM stdin;
    public               postgres    false    225   _                 0    16480    relacao_user_curtida 
   TABLE DATA           @   COPY public.relacao_user_curtida (userid, musicaid) FROM stdin;
    public               postgres    false    226   2_                 0    16495    relacao_user_descurtida 
   TABLE DATA           C   COPY public.relacao_user_descurtida (userid, musicaid) FROM stdin;
    public               postgres    false    227   Y_       �          0    16420    usuarios_cadastrados 
   TABLE DATA           M   COPY public.usuarios_cadastrados (userid, nome, username, senha) FROM stdin;
    public               postgres    false    218   �_                  0    0 "   artistas_cadastrados_artistaid_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.artistas_cadastrados_artistaid_seq', 12, true);
          public               postgres    false    219                       0    0 &   historico_descurtida_id_descurtida_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.historico_descurtida_id_descurtida_seq', 9, true);
          public               postgres    false    228                       0    0 *   historico_pesquisa_usuario_id_pesquisa_seq    SEQUENCE SET     Y   SELECT pg_catalog.setval('public.historico_pesquisa_usuario_id_pesquisa_seq', 63, true);
          public               postgres    false    230                       0    0     musicas_cadastradas_musicaid_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.musicas_cadastradas_musicaid_seq', 12, true);
          public               postgres    false    221                       0    0    playlist_playlistid_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.playlist_playlistid_seq', 5, true);
          public               postgres    false    223                       0    0    usuarios_cadastrados_userid_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.usuarios_cadastrados_userid_seq', 5, true);
          public               postgres    false    217            Q           2606    16438 :   artistas_cadastrados artistas_cadastrados_nome_artista_key 
   CONSTRAINT     }   ALTER TABLE ONLY public.artistas_cadastrados
    ADD CONSTRAINT artistas_cadastrados_nome_artista_key UNIQUE (nome_artista);
 d   ALTER TABLE ONLY public.artistas_cadastrados DROP CONSTRAINT artistas_cadastrados_nome_artista_key;
       public                 postgres    false    220            S           2606    16436 .   artistas_cadastrados artistas_cadastrados_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.artistas_cadastrados
    ADD CONSTRAINT artistas_cadastrados_pkey PRIMARY KEY (artistaid);
 X   ALTER TABLE ONLY public.artistas_cadastrados DROP CONSTRAINT artistas_cadastrados_pkey;
       public                 postgres    false    220            _           2606    16516 .   historico_descurtida historico_descurtida_pkey 
   CONSTRAINT     w   ALTER TABLE ONLY public.historico_descurtida
    ADD CONSTRAINT historico_descurtida_pkey PRIMARY KEY (id_descurtida);
 X   ALTER TABLE ONLY public.historico_descurtida DROP CONSTRAINT historico_descurtida_pkey;
       public                 postgres    false    229            a           2606    16533 :   historico_pesquisa_usuario historico_pesquisa_usuario_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.historico_pesquisa_usuario
    ADD CONSTRAINT historico_pesquisa_usuario_pkey PRIMARY KEY (id_pesquisa);
 d   ALTER TABLE ONLY public.historico_pesquisa_usuario DROP CONSTRAINT historico_pesquisa_usuario_pkey;
       public                 postgres    false    231            U           2606    16447 ,   musicas_cadastradas musicas_cadastradas_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.musicas_cadastradas
    ADD CONSTRAINT musicas_cadastradas_pkey PRIMARY KEY (musicaid);
 V   ALTER TABLE ONLY public.musicas_cadastradas DROP CONSTRAINT musicas_cadastradas_pkey;
       public                 postgres    false    222            W           2606    16459    playlist playlist_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_pkey PRIMARY KEY (playlistid);
 @   ALTER TABLE ONLY public.playlist DROP CONSTRAINT playlist_pkey;
       public                 postgres    false    224            Y           2606    16469 4   relacao_playlist_musica relacao_playlist_musica_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.relacao_playlist_musica
    ADD CONSTRAINT relacao_playlist_musica_pkey PRIMARY KEY (playlistid, musicaid);
 ^   ALTER TABLE ONLY public.relacao_playlist_musica DROP CONSTRAINT relacao_playlist_musica_pkey;
       public                 postgres    false    225    225            [           2606    16484 .   relacao_user_curtida relacao_user_curtida_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public.relacao_user_curtida
    ADD CONSTRAINT relacao_user_curtida_pkey PRIMARY KEY (userid, musicaid);
 X   ALTER TABLE ONLY public.relacao_user_curtida DROP CONSTRAINT relacao_user_curtida_pkey;
       public                 postgres    false    226    226            ]           2606    16499 4   relacao_user_descurtida relacao_user_descurtida_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.relacao_user_descurtida
    ADD CONSTRAINT relacao_user_descurtida_pkey PRIMARY KEY (userid, musicaid);
 ^   ALTER TABLE ONLY public.relacao_user_descurtida DROP CONSTRAINT relacao_user_descurtida_pkey;
       public                 postgres    false    227    227            M           2606    16427 .   usuarios_cadastrados usuarios_cadastrados_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.usuarios_cadastrados
    ADD CONSTRAINT usuarios_cadastrados_pkey PRIMARY KEY (userid);
 X   ALTER TABLE ONLY public.usuarios_cadastrados DROP CONSTRAINT usuarios_cadastrados_pkey;
       public                 postgres    false    218            O           2606    16429 6   usuarios_cadastrados usuarios_cadastrados_username_key 
   CONSTRAINT     u   ALTER TABLE ONLY public.usuarios_cadastrados
    ADD CONSTRAINT usuarios_cadastrados_username_key UNIQUE (username);
 `   ALTER TABLE ONLY public.usuarios_cadastrados DROP CONSTRAINT usuarios_cadastrados_username_key;
       public                 postgres    false    218            j           2606    16522 7   historico_descurtida historico_descurtida_musicaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_descurtida
    ADD CONSTRAINT historico_descurtida_musicaid_fkey FOREIGN KEY (musicaid) REFERENCES public.musicas_cadastradas(musicaid);
 a   ALTER TABLE ONLY public.historico_descurtida DROP CONSTRAINT historico_descurtida_musicaid_fkey;
       public               postgres    false    222    229    4693            k           2606    16517 5   historico_descurtida historico_descurtida_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_descurtida
    ADD CONSTRAINT historico_descurtida_userid_fkey FOREIGN KEY (userid) REFERENCES public.usuarios_cadastrados(userid);
 _   ALTER TABLE ONLY public.historico_descurtida DROP CONSTRAINT historico_descurtida_userid_fkey;
       public               postgres    false    218    4685    229            l           2606    16534 A   historico_pesquisa_usuario historico_pesquisa_usuario_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_pesquisa_usuario
    ADD CONSTRAINT historico_pesquisa_usuario_userid_fkey FOREIGN KEY (userid) REFERENCES public.usuarios_cadastrados(userid);
 k   ALTER TABLE ONLY public.historico_pesquisa_usuario DROP CONSTRAINT historico_pesquisa_usuario_userid_fkey;
       public               postgres    false    231    4685    218            b           2606    16448 6   musicas_cadastradas musicas_cadastradas_artistaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musicas_cadastradas
    ADD CONSTRAINT musicas_cadastradas_artistaid_fkey FOREIGN KEY (artistaid) REFERENCES public.artistas_cadastrados(artistaid);
 `   ALTER TABLE ONLY public.musicas_cadastradas DROP CONSTRAINT musicas_cadastradas_artistaid_fkey;
       public               postgres    false    4691    220    222            c           2606    16460    playlist playlist_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_userid_fkey FOREIGN KEY (userid) REFERENCES public.usuarios_cadastrados(userid);
 G   ALTER TABLE ONLY public.playlist DROP CONSTRAINT playlist_userid_fkey;
       public               postgres    false    224    218    4685            d           2606    16475 =   relacao_playlist_musica relacao_playlist_musica_musicaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.relacao_playlist_musica
    ADD CONSTRAINT relacao_playlist_musica_musicaid_fkey FOREIGN KEY (musicaid) REFERENCES public.musicas_cadastradas(musicaid);
 g   ALTER TABLE ONLY public.relacao_playlist_musica DROP CONSTRAINT relacao_playlist_musica_musicaid_fkey;
       public               postgres    false    225    222    4693            e           2606    16470 ?   relacao_playlist_musica relacao_playlist_musica_playlistid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.relacao_playlist_musica
    ADD CONSTRAINT relacao_playlist_musica_playlistid_fkey FOREIGN KEY (playlistid) REFERENCES public.playlist(playlistid);
 i   ALTER TABLE ONLY public.relacao_playlist_musica DROP CONSTRAINT relacao_playlist_musica_playlistid_fkey;
       public               postgres    false    224    225    4695            f           2606    16490 7   relacao_user_curtida relacao_user_curtida_musicaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.relacao_user_curtida
    ADD CONSTRAINT relacao_user_curtida_musicaid_fkey FOREIGN KEY (musicaid) REFERENCES public.musicas_cadastradas(musicaid);
 a   ALTER TABLE ONLY public.relacao_user_curtida DROP CONSTRAINT relacao_user_curtida_musicaid_fkey;
       public               postgres    false    226    4693    222            g           2606    16485 5   relacao_user_curtida relacao_user_curtida_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.relacao_user_curtida
    ADD CONSTRAINT relacao_user_curtida_userid_fkey FOREIGN KEY (userid) REFERENCES public.usuarios_cadastrados(userid);
 _   ALTER TABLE ONLY public.relacao_user_curtida DROP CONSTRAINT relacao_user_curtida_userid_fkey;
       public               postgres    false    218    226    4685            h           2606    16505 =   relacao_user_descurtida relacao_user_descurtida_musicaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.relacao_user_descurtida
    ADD CONSTRAINT relacao_user_descurtida_musicaid_fkey FOREIGN KEY (musicaid) REFERENCES public.musicas_cadastradas(musicaid);
 g   ALTER TABLE ONLY public.relacao_user_descurtida DROP CONSTRAINT relacao_user_descurtida_musicaid_fkey;
       public               postgres    false    4693    222    227            i           2606    16500 ;   relacao_user_descurtida relacao_user_descurtida_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.relacao_user_descurtida
    ADD CONSTRAINT relacao_user_descurtida_userid_fkey FOREIGN KEY (userid) REFERENCES public.usuarios_cadastrados(userid);
 e   ALTER TABLE ONLY public.relacao_user_descurtida DROP CONSTRAINT relacao_user_descurtida_userid_fkey;
       public               postgres    false    218    4685    227               �   x����0��~O���X�i ,b�et�J���khk��{��j�O(���%3���k��"�T�+�.Oj�q�rUv�&ϰ�D-I�ZN1ǷO�3ٺ�M}�-���Ak�O��^�]�q1y��,�5�?B(�      
   5   x���  C�3@wq�9��צuKB:�u�"Y��
�\���R�x��w         0  x�U��n�0�������v� �K��EeM�R�~N@�����36l���3�A9��-<�%���h40Z��F�
"���eW�*�AYE*jJlK̒ǒ��5��bg*z��g[�,���Ԁ}i�Mi��ކ�������׭�N�
Kzİ������z9ŪO/�=pJw�l�c�ܪ����1i���`�=��5�{&�%CXa!:��!��)<�+H�h!��A�R�py��vt.�N.i�gOy��5���	�i�3./�<H��y�UW��Y����2���w��w��S���)��5��S���Ȱ{J         F  x�]��n�@�ϳO�C��jd��\
�v�jlT���l$�b+��ve�y�l��$�|�����!(����$�5�������;öGZrh�9$���%E��s��G�#~Xz�m�q�.P�����զD�K��x<��]��7�!�x��CHy���i`*K\�+T�
��q=���jV|)��rר�_��G�D��T�j�Tnq�n�6kU�]������j�_�2�{΁ii6���S���g!�H���k�l�h�J�_�?uޣN��T�AtO�lB^��Dw2f.Y�=�w~��K�ɢ�4���Yo��-=u�	K�H�Fu#�M����3��	f�         9   x�3��I�4�4�2��qs��4�2��--�LN,642�4�2�r����=... ��            x�3��2�4bs ��2�4����� )L            x�3�44�2�44����� ��            x�3�44�2�44������ ��      �   a   x�3�tI��L�QpJ,*�/���)��442�2�JMNT��M���9���9���99��L8}J��$��)�)gH~^f^F"�������� �c[     